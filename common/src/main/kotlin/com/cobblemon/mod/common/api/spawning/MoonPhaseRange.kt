package com.cobblemon.mod.common.api.spawning

import com.cobblemon.mod.common.api.spawning.MoonPhaseRange.Companion.moonPhaseRanges
import com.cobblemon.mod.common.api.spawning.condition.SpawningCondition

/**
 * A range of moon phases for a world mainly to be used in [SpawningCondition]s. A moon phase range
 * is defined as any number of phase integer ranges (0-7).
 *
 * There are a series of in-built moon phase ranges that you can replace if they don't suit
 * your definitions.
 *
 * If you want a moon phase range to be referenced by name in [SpawningCondition]s, you need
 * to register it, by name, in [moonPhaseRanges].
 *
 * @author Hiroku
 * @since January 26th, 2022
 */
class MoonPhaseRange : IntRanges {
    companion object {
        val moonPhaseRanges = mutableMapOf(
            "crescent" to MoonPhaseRange(3..3, 5..5),
            "gibbous" to MoonPhaseRange(1..1, 7..7),
            "full" to MoonPhaseRange(0..0),
            "new" to MoonPhaseRange(4..4),
            "quarter" to MoonPhaseRange(3..3, 7..7)
        )
    }

    constructor() : super()
    constructor(vararg ranges: IntRange) : super(*ranges)
}