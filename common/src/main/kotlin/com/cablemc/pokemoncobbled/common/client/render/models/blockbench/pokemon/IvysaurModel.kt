package com.cablemc.pokemoncobbled.common.client.render.models.blockbench.pokemon

import com.cablemc.pokemoncobbled.common.client.render.models.blockbench.animation.QuadrupedWalkAnimation
import com.cablemc.pokemoncobbled.common.client.render.models.blockbench.asTransformed
import com.cablemc.pokemoncobbled.common.client.render.models.blockbench.frame.*
import com.cablemc.pokemoncobbled.common.client.render.models.blockbench.pose.PoseType
import com.cablemc.pokemoncobbled.common.client.render.models.blockbench.pose.TransformedModelPart.Companion.Y_AXIS
import com.cablemc.pokemoncobbled.common.entity.pokemon.PokemonBehaviourFlag
import net.minecraft.client.model.ModelPart
import net.minecraft.util.math.Vec3d

class IvysaurModel(root: ModelPart) : PokemonPoseableModel(), HeadedFrame, QuadrupedFrame {
    override val rootPart = root.registerChildWithSpecificChildren("ivysaur", listOf("head","bulb","body","leg_front_right","leg_front_left","leg_hind_right","leg_hind_left","leaf_front","leaf_front2","leaf_right","leaf_right2","leaf_left","leaf_left2","leaf_back","leaf_back2"
    ))
    override val head = getPart("head")
    override val foreLeftLeg = getPart("leg_front_left")
    override val foreRightLeg = getPart("leg_front_right")
    override val hindLeftLeg = getPart("leg_back_left")
    override val hindRightLeg = getPart("leg_back_right")

    override val portraitScale = 1.65F
    override val portraitTranslation = Vec3d(-0.1, -0.5, 0.0)
    override val profileScale = 1.0F
    override val profileTranslation = Vec3d(0.0, 0.0, 0.0)

    override fun registerPoses() {
        registerPose(
            poseName = "standing",
            poseTypes = setOf(PoseType.NONE, PoseType.PROFILE),
            transformTicks = 10,
            condition = { !it.isMoving.get() },
            idleAnimations = arrayOf(
                singleBoneLook(),
                bedrock("ivysaur", "ground_idle1")
            ),
            transformedParts = arrayOf()
        )

        registerPose(
            poseType = PoseType.WALK,
            transformTicks = 10,
            condition = { it.isMoving.get() && !it.getBehaviourFlag(PokemonBehaviourFlag.EXCITED) },
            idleAnimations = arrayOf(
                singleBoneLook(),
                bedrock("ivysaur", "ground_idle1"),
                bedrock("ivysaur", "ground_walk")
            ),
            transformedParts = emptyArray()
        )
    }
}
