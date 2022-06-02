package com.cablemc.pokemoncobbled.common.battles

import com.cablemc.pokemoncobbled.common.api.battles.model.actor.BattleActor
import com.cablemc.pokemoncobbled.common.battles.pokemon.BattlePokemon

class ActiveBattlePokemon(val actor: BattleActor, var battlePokemon: BattlePokemon? = null): Targetable {
    val battle = actor.battle
    var selectableMoves: List<InBattleMove> = emptyList()
    fun getSide() = actor.getSide()
    override fun getAllActivePokemon() = battle.activePokemon.toList()
    override fun getActorPokemon() = actor.activePokemon.toList()
    override fun getFormat() = battle.format
    override fun isAllied(other: Targetable) = getSide() == (other as ActiveBattlePokemon).getSide()
    override fun hasPokemon() = battlePokemon != null

    fun getPNX(): String {
        return actor.showdownId + getLetter()
    }
}