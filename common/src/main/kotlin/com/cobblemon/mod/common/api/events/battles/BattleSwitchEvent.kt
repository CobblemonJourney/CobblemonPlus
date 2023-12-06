package com.cobblemon.mod.common.api.events.battles

import com.cobblemon.mod.common.api.battles.model.PokemonBattle
import com.cobblemon.mod.common.pokemon.Pokemon

data class BattleSwitchEvent(
    val battle: PokemonBattle,
    val pokemon: Pokemon
)