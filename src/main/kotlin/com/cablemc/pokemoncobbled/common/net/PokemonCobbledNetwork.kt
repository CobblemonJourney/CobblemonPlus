package com.cablemc.pokemoncobbled.common.net

import com.cablemc.pokemoncobbled.common.PokemonCobbled
import com.cablemc.pokemoncobbled.common.api.event.net.MessageBuiltEvent
import com.cablemc.pokemoncobbled.common.api.net.NetworkPacket
import com.cablemc.pokemoncobbled.common.net.messages.client.PokemonUpdatePacket
import com.cablemc.pokemoncobbled.mod.PokemonCobbledMod
import net.minecraft.resources.ResourceLocation
import net.minecraft.server.level.ServerPlayer
import net.minecraftforge.fmllegacy.network.NetworkDirection
import net.minecraftforge.fmllegacy.network.NetworkRegistry
import net.minecraftforge.fmllegacy.network.PacketDistributor

/**
 * Registers Pokémon Cobbled packets. Packet handlers are set up on handling the [MessageBuiltEvent] dispatched from here.
 *
 * This class also contains short functions for dispatching our packets to a player, all players, or to the entire server.
 *
 * @author Hiroku
 * @since November 27th, 2021
 */
object PokemonCobbledNetwork {
    const val PROTOCOL_VERSION = "1"

    private var discriminator = 0

    fun ServerPlayer.sendPacket(packet: NetworkPacket) = sendToPlayer(this, packet)
    fun sendToPlayer(player: ServerPlayer, packet: NetworkPacket) = channel.send(PacketDistributor.PLAYER.with { player }, packet)
    fun sendToServer(packet: NetworkPacket) = channel.sendToServer(packet)
    fun sendToAllPlayers(packet: NetworkPacket) = channel.sendToServer(packet)

    val channel = NetworkRegistry.newSimpleChannel(
        ResourceLocation(PokemonCobbled.MODID, "main"),
        { PROTOCOL_VERSION },
        PROTOCOL_VERSION::equals,
        PROTOCOL_VERSION::equals
    )

    fun register() {
        buildMessage<PokemonUpdatePacket>(NetworkDirection.PLAY_TO_CLIENT)
    }

    private inline fun <reified P : NetworkPacket> buildMessage(direction: NetworkDirection) {
        val messageBuilder = channel.messageBuilder(P::class.java, discriminator++, direction)
            .encoder { packet, buffer -> packet.encode(buffer) }
            .decoder { buffer -> P::class.java.newInstance().also { it.decode(buffer) } }
        PokemonCobbledMod.EVENT_BUS.post(MessageBuiltEvent(P::class.java, messageBuilder))
        messageBuilder.add()
    }
}