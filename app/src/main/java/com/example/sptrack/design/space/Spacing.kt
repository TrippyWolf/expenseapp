package com.example.sptrack.design.space

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object Spacing {
    val ZeroX = 0.dp

    val Spacing_4 = 4.dp
    val Spacing_8 = 8.dp
    val Spacing_16 = 16.dp

    fun times(x: Float = 2.0f): Dp {
        return Spacing_4.times(x)
    }
}