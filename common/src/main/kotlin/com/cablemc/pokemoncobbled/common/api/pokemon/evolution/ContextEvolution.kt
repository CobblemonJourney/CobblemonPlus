package com.cablemc.pokemoncobbled.common.api.pokemon.evolution

import com.cablemc.pokemoncobbled.common.pokemon.Pokemon
import com.cablemc.pokemoncobbled.common.pokemon.evolution.ItemInteractionEvolution
import com.cablemc.pokemoncobbled.common.pokemon.evolution.TradeEvolution

/**
 * Represents an evolution of a [Pokemon] that can only occur during specific actions and with added context.
 * For the default implementations see [ItemInteractionEvolution] & [TradeEvolution].
 *
 * @param RC The context given at runtime when querying the [Evolution].
 * @param TC The context that is serialized from JSON during species loading, this is what the [RC] is expected to match against.
 * @author Licious
 * @since March 19th, 2022
 */
interface ContextEvolution<RC, TC> : Evolution {

    /**
     * The target context for this [Evolution] to even be tested.
     */
    val requiredContext: TC

    /**
     * Attempts to evolve the given [Pokemon] under the given context of type [RC].
     *
     * @param pokemon The [Pokemon] attempting to evolve.
     * @param context The context of this query.
     * @return If the evolution was successful.
     */
    fun attemptEvolution(pokemon: Pokemon, context: RC): Boolean {
        if (this.testContext(pokemon, context) && super.test(pokemon)) {
            super.evolve(pokemon)
            return true
        }
        return false
    }

    /**
     * Checks if the given context is valid for the [requiredContext].
     *
     * @param pokemon The [Pokemon] attempting to evolve.
     * @param context The context of this query.
     * @return If the context matched the [requiredContext].
     */
    fun testContext(pokemon: Pokemon, context: RC): Boolean

}