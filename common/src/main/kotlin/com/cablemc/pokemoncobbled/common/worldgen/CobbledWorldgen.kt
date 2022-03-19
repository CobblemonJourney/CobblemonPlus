package com.cablemc.pokemoncobbled.common.worldgen

import dev.architectury.registry.level.biome.BiomeModifications
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.levelgen.GenerationStep.Decoration.UNDERGROUND_ORES
import net.minecraft.world.level.levelgen.placement.BiomeFilter
import net.minecraft.world.level.levelgen.placement.CountPlacement
import net.minecraft.world.level.levelgen.placement.InSquarePlacement
import net.minecraft.world.level.levelgen.placement.PlacementModifier
import net.minecraft.world.level.levelgen.placement.RarityFilter

object CobbledWorldgen {

    init {
        EvolutionOres
    }

    fun register() {
        BiomeModifications.addProperties { _, properties ->
            properties.generationProperties.addFeature(UNDERGROUND_ORES, EvolutionOres.PLACED_FEATURE)
        }
//        BiomeModifications.addProperties( { true } ) { _, properties ->
//            properties.generationProperties.addFeature(UNDERGROUND_ORES, EvolutionOres.PLACED_FEATURE)
//        }
    }

    fun orePlacement(placementModifier: PlacementModifier, placementModifier2: PlacementModifier): List<PlacementModifier> {
        return listOf(placementModifier, InSquarePlacement.spread(), placementModifier2, BiomeFilter.biome())
    }

    fun commonOrePlacement(i: Int, placementModifier: PlacementModifier): List<PlacementModifier> {
        return orePlacement(CountPlacement.of(i), placementModifier)
    }

    fun rareOrePlacement(i: Int, placementModifier: PlacementModifier): List<PlacementModifier> {
        return orePlacement(RarityFilter.onAverageOnceEvery(i), placementModifier)
    }

    fun test(biome: Biome) {

    }
}