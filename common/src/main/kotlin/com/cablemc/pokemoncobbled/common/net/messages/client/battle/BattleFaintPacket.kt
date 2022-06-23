package com.cablemc.pokemoncobbled.common.net.messages.client.battle

import com.cablemc.pokemoncobbled.common.api.net.NetworkPacket
import net.minecraft.network.PacketByteBuf
import net.minecraft.text.MutableText

/**
 * Reports that a specific Pokémon fainted. This triggers a specific tile animation.
 *
 * Handled by [com.cablemc.pokemoncobbled.common.client.net.battle.BattleFaintHandler].
 *
 * @author Hiroku
 * @since May 22nd, 2022
 */
class BattleFaintPacket() : NetworkPacket {
    lateinit var pnx: String
    lateinit var message: MutableText
    constructor(pnx: String, message: MutableText): this() {
        this.pnx = pnx
        this.message = message
    }
    override fun encode(buffer: PacketByteBuf) {
        buffer.writeString(pnx)
        buffer.writeText(message)
    }

    override fun decode(buffer: PacketByteBuf) {
        pnx = buffer.readString()
        message = buffer.readText().copy()
    }
}