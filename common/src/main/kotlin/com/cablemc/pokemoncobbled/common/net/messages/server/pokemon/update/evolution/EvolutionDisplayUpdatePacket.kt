/*
 * Copyright (C) 2022 Pokemon Cobbled Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.cablemc.pokemoncobbled.common.net.messages.server.pokemon.update.evolution

import com.cablemc.pokemoncobbled.common.api.pokemon.evolution.Evolution
import com.cablemc.pokemoncobbled.common.api.pokemon.evolution.EvolutionDisplay
import com.cablemc.pokemoncobbled.common.net.messages.client.storage.EvolutionLikeUpdatePacket
import com.cablemc.pokemoncobbled.common.pokemon.Pokemon
import com.cablemc.pokemoncobbled.common.pokemon.evolution.CobbledEvolutionDisplay
import com.cablemc.pokemoncobbled.common.pokemon.evolution.variants.DummyEvolution
import net.minecraft.network.PacketByteBuf

/**
 * The base for all [EvolutionDisplay] updates.
 *
 * @author Licious
 * @since April 28th, 2022.
 */
abstract class EvolutionDisplayUpdatePacket : EvolutionLikeUpdatePacket<EvolutionDisplay, Evolution>() {

    override var current: EvolutionDisplay = CobbledEvolutionDisplay("dummy", Pokemon())
    override var sending: Evolution = DummyEvolution()

    protected var evolutionId = "dummy"

    override fun createSending(pokemon: Pokemon): Evolution {
        throw UnsupportedOperationException("Evolutions are resolved on the server side")
    }

    final override fun encodeSending(buffer: PacketByteBuf) {
        buffer.writeString(this.current.id)
    }

    final override fun decodeSending(buffer: PacketByteBuf) {
        this.evolutionId = buffer.readString()
    }

}