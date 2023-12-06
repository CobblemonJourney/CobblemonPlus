package com.cobblemon.mod.common.api.events.pokemon

import com.cobblemon.mod.common.api.events.Cancelable
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity
import net.minecraft.item.ItemStack
import net.minecraft.server.network.ServerPlayerEntity

data class PokemonSwapHeldItemEvent(
    val player: ServerPlayerEntity,
    val entity: PokemonEntity,
    val itemStack: ItemStack,
) : Cancelable()