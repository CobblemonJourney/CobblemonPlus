/*
 * Copyright (C) 2022 Pokemon Cobbled Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.cablemc.pokemoncobbled.common.util.math.geometry

import com.cablemc.pokemoncobbled.common.util.collections.immutableArrayOf
import kotlin.math.cos
import kotlin.math.sin

/**
 * An axis within three dimensional space.
 *
 * @author landonjw
 */
enum class Axis(val x: Float, val y: Float, val z: Float) {
    X_AXIS(1f, 0f, 0f),
    Y_AXIS(0f, 1f, 0f),
    Z_AXIS(0f, 0f, 1f);

    /**
     * Gets the [rotation matrix](https://en.wikipedia.org/wiki/Rotation_matrix) for an axis,
     * based off a given angle of rotation.
     *
     * @param angle the angle to rotate by in radians, default 0
     * @return a new rotation matrix instance for a given rotation
     */
    fun getRotationMatrix(angle: Float = 0f): TransformationMatrix = when (this) {
        X_AXIS -> TransformationMatrix(
            immutableArrayOf(
            immutableArrayOf(1f,   0f,           0f,          0f),
            immutableArrayOf(0f,   cos(angle),   -sin(angle),  0f),
            immutableArrayOf(0f,   sin(angle),  cos(angle),  0f),
            immutableArrayOf(0f,   0f,           0f,          1f)
        )
        )
        Y_AXIS -> TransformationMatrix(
            immutableArrayOf(
            immutableArrayOf(cos(angle),  0f,   sin(angle), 0f),
            immutableArrayOf(0f,          1f,   0f,          0f),
            immutableArrayOf(-sin(angle),  0f,   cos(angle),  0f),
            immutableArrayOf(0f,          0f,   0f,          1f)
        )
        )
        Z_AXIS -> TransformationMatrix(
            immutableArrayOf(
            immutableArrayOf(cos(angle),  -sin(angle),  0f,  0f),
            immutableArrayOf(sin(angle),  cos(angle),   0f,  0f),
            immutableArrayOf(0f,          0f,           1f,  0f),
            immutableArrayOf(0f,          0f,           0f,  1f)
        )
        )
    }

}