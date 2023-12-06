package com.cobblemon.mod.common.api.events.battles

import com.cobblemon.mod.common.api.battles.model.PokemonBattle
import com.cobblemon.mod.common.api.moves.MoveTemplate
import com.cobblemon.mod.common.battles.pokemon.BattlePokemon
import net.minecraft.server.network.ServerPlayerEntity

data class BattleUseMoveEvent(
    val battle: PokemonBattle,
    val players: List<ServerPlayerEntity>,
    val userPokemon: BattlePokemon,
    val move: MoveTemplate
)