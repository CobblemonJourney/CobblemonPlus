/*
 * Copyright (C) 2023 Cobblemon Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.cobblemon.mod.common.client.render.models.blockbench.pokemon

import com.cobblemon.mod.common.client.render.models.blockbench.PoseableEntityState
import com.cobblemon.mod.common.client.render.models.blockbench.animation.StatefulAnimation
import com.cobblemon.mod.common.client.render.models.blockbench.bedrock.animation.BedrockStatefulAnimation
import com.cobblemon.mod.common.client.render.models.blockbench.frame.HeadedFrame
import com.cobblemon.mod.common.client.render.models.blockbench.frame.ModelFrame
import com.cobblemon.mod.common.client.render.models.blockbench.pose.Bone
import com.cobblemon.mod.common.client.render.models.blockbench.pose.Pose
import com.cobblemon.mod.common.client.render.models.blockbench.withPosition
import com.cobblemon.mod.common.entity.PoseType
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity
import com.cobblemon.mod.common.util.adapters.Vec3dAdapter
import com.google.gson.*
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.function.Supplier
import net.minecraft.util.math.Vec3d

/**
 * The goal of this is to allow a PokemonPoseableModel to be constructed from a JSON instead of being
 * created via a class. By being loadable from JSON, the full flow of a new Pokémon can be accomplished
 * from a resource + data pack.
 *
 * @author Hiroku
 * @since August 7th, 2022
 */
class JsonPokemonPoseableModel(override val rootPart: Bone) : PokemonPoseableModel(), HeadedFrame {
    companion object {
        val gson = GsonBuilder()
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .registerTypeAdapter(Vec3d::class.java, Vec3dAdapter)
            .setExclusionStrategies(JsonModelExclusion)
            .registerTypeAdapter(
                TypeToken.getParameterized(
                    Supplier::class.java,
                    TypeToken.getParameterized(
                        StatefulAnimation::class.java,
                        PokemonEntity::class.java,
                        ModelFrame::class.java
                    ).type
                ).type,
                StatefulAnimationAdapter
            )
            .registerTypeAdapter(Pose::class.java, PoseAdapter)
            .registerTypeAdapter(JsonPokemonPoseableModel::class.java, JsonPokemonPoseableModelAdapter)
            .create()

        fun registerFactory(id: String, factory: AnimationReferenceFactory) {
            ANIMATION_FACTORIES[id] = factory;
        }

        private val ANIMATION_FACTORIES = mutableMapOf<String, AnimationReferenceFactory>()
    }

    override fun registerPoses() {}

    @SerializedName("head")
    val headJoint: String? = null

    override val head: Bone by lazy { headJoint?.let { getPart(it) } ?: rootPart }


    @SerializedName("portraitScale")
    private val _portraitScale: Float? = null
    @SerializedName("portraitTranslation")
    private val _portraitTranslation: Vec3d? = null

    @SerializedName("profileScale")
    private val _profileScale: Float? = null
    @SerializedName("profileTranslation")
    private val _profileTranslation: Vec3d? = null

    override val portraitScale
        get() = _portraitScale ?: 1F
    override val portraitTranslation
        get() = _portraitTranslation ?: Vec3d(0.0, 0.0, 0.0)

    override val profileScale
        get() = _profileScale ?: 1F
    override val profileTranslation
        get() = _profileTranslation ?: Vec3d(0.0, 0.0, 0.0)



    val faint: Supplier<StatefulAnimation<PokemonEntity, ModelFrame>>? = null
    val cry: Supplier<StatefulAnimation<PokemonEntity, ModelFrame>>? = null

    override fun getFaintAnimation(pokemonEntity: PokemonEntity, state: PoseableEntityState<PokemonEntity>) = faint?.get()
    override val cryAnimation = CryProvider { _, _ -> cry?.get()?.also { if (it is BedrockStatefulAnimation) it.setPreventsIdle(false).isPosePauserAnimation(true) } }

    object JsonModelExclusion: ExclusionStrategy {
        override fun shouldSkipField(f: FieldAttributes): Boolean {
            return f.declaringClass.simpleName !in listOf(
                "JsonPokemonPoseableModel",
                "PoseableEntityModel",
                "Pose"
            )
        }

        override fun shouldSkipClass(clazz: Class<*>): Boolean {
            return false
        }

    }

    object StatefulAnimationAdapter : JsonDeserializer<Supplier<StatefulAnimation<PokemonEntity, ModelFrame>>> {
        var preventsIdleDefault = true
        override fun deserialize(json: JsonElement, type: Type, ctx: JsonDeserializationContext): Supplier<StatefulAnimation<PokemonEntity, ModelFrame>> {
            json as JsonPrimitive
            val animString = json.asString
            val format = animString.substringBefore("(")
            return Supplier { ANIMATION_FACTORIES[format]!!.stateful(JsonPokemonPoseableModelAdapter.model!!, animString) }
        }
    }

    object JsonPokemonPoseableModelAdapter : InstanceCreator<JsonPokemonPoseableModel> {
        var modelPart: Bone? = null
        var model: JsonPokemonPoseableModel? = null
        override fun createInstance(type: Type): JsonPokemonPoseableModel {
            return JsonPokemonPoseableModel(modelPart!!).also {
                model = it
                it.loadAllNamedChildren(modelPart!!)
            }
        }
    }
    object PoseAdapter : JsonDeserializer<Pose<PokemonEntity, ModelFrame>> {
        override fun deserialize(json: JsonElement, type: Type, ctx: JsonDeserializationContext): Pose<PokemonEntity, ModelFrame> {
            val model = JsonPokemonPoseableModelAdapter.model!!
            val obj = json as JsonObject
            val poseName = obj.get("poseName").asString
            val poseTypes = (obj.get("poseTypes")?.asJsonArray?.map { name ->
                PoseType.values().find { it.name.lowercase() == name.asString.lowercase() }
                    ?: throw IllegalArgumentException("Unknown pose type ${name.asString}")
            } ?: emptyList()) + if (obj.get("allPoseTypes")?.asBoolean == true) PoseType.values().toList() else emptyList()
            val transformTicks = obj.get("transformTicks")?.asInt ?: 10

            val conditionsList = mutableListOf<(PokemonEntity) -> Boolean>()

            val mustBeInBattle = json.get("isBattle")?.asBoolean
            if (mustBeInBattle != null) {
                conditionsList.add { mustBeInBattle == it.isBattling }
            }
            val mustBeTouchingWater = json.get("isTouchingWater")?.asBoolean
            if (mustBeTouchingWater != null) {
                conditionsList.add { mustBeTouchingWater == it.isTouchingWater }
            }

            val poseCondition: (PokemonEntity) -> Boolean = if (conditionsList.isEmpty()) { { true } } else conditionsList.reduce { acc, function -> { acc(it) && function(it) } }

            val transformedParts = obj.get("transformedParts")?.asJsonArray?.map {
                it as JsonObject
                val partName = it.get("part").asString
                val part = model.getPart(partName)
                val rotation = it.get("rotation")?.asJsonArray?.let { Vec3d(it[0].asDouble, it[1].asDouble, it[2].asDouble) } ?: Vec3d.ZERO
                val position = it.get("position")?.asJsonArray?.let { Vec3d(it[0].asDouble, it[1].asDouble, it[2].asDouble) } ?: Vec3d.ZERO
                val isVisible = it.get("isVisible")?.asBoolean ?: true
                return@map part.withPosition(position.x, position.y, position.z).withRotationDegrees(rotation.x, rotation.y, rotation.z).withVisibility(isVisible)
            }?.toTypedArray() ?: arrayOf()

            val idleAnimations = (obj.get("animations")?.asJsonArray ?: JsonArray()).asJsonArray.mapNotNull {
                val animString = it.asString
                if (animString == "look") {
                    return@mapNotNull JsonPokemonPoseableModelAdapter.model!!.singleBoneLook<PokemonEntity>()
                } else {
                    val anim = animString.substringBefore("(")

                    if(ANIMATION_FACTORIES.contains(anim)) {
                        return@mapNotNull ANIMATION_FACTORIES[anim]?.stateless(model, animString)
                    }
                }
                return@mapNotNull null
            }.toTypedArray()

            val quirks = (obj.get("quirks")?.asJsonArray ?: JsonArray()).map { json ->
                json as JsonObject
                val name = json.get("name").asString
                val animations: (state: PoseableEntityState<PokemonEntity>) -> List<StatefulAnimation<PokemonEntity, *>> = { _ ->
                    (json.get("animations")?.asJsonArray ?: JsonArray()).map { animJson ->
                        val animString = animJson.asString

                        val anim = animString.substringBefore("(")

                        StatefulAnimationAdapter.preventsIdleDefault = false
                        val animation = if(ANIMATION_FACTORIES.contains(anim)) {
                            ANIMATION_FACTORIES[anim]?.stateful(model, animString)
                        } else {
                            null
                        }
                        StatefulAnimationAdapter.preventsIdleDefault = true
                        animation
                    }.filterNotNull()
                }

                val loopTimes = json.get("loopTimes")?.asInt ?: 1
                val minSeconds = json.get("minSecondsBetweenOccurrences")?.asFloat ?: 8F
                val maxSeconds = json.get("maxSecondsBetweenOccurrences")?.asFloat ?: 30F

                model.quirkMultiple(
                    name = name,
                    secondsBetweenOccurrences = minSeconds to maxSeconds,
                    condition = { true },
                    loopTimes = 1..loopTimes,
                    animations = animations
                )
            }

            return Pose(
                poseName = poseName,
                poseTypes = poseTypes.toSet(),
                condition = poseCondition,
                transformTicks =  transformTicks,
                idleAnimations = idleAnimations,
                transformedParts = transformedParts,
                quirks = quirks.toTypedArray()
            )
        }
    }
}