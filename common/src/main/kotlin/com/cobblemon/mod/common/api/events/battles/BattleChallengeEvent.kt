package com.cobblemon.mod.common.api.events.battles

import com.cobblemon.mod.common.api.events.Cancelable
import net.minecraft.entity.Entity
import net.minecraft.server.network.ServerPlayerEntity
import java.util.UUID

data class BattleChallengeEvent(
    val player: ServerPlayerEntity,
    val entity: Entity,
    val leadingPokemon: UUID
) : Cancelable()