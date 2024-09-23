package com.example.sptrack.design

import androidx.compose.ui.Modifier
import androidx.core.graphics.ColorUtils
import androidx.compose.ui.graphics.Color as ComposeColor

fun Modifier.conditional(
    predicate: Boolean,
    other: Modifier.() -> Modifier
): Modifier =
    if (predicate) {
        this.then(other())
    } else {
        this
    }

@OptIn(ExperimentalUnsignedTypes::class)
fun ComposeColor.invert(): ComposeColor {
    val hsl = floatArrayOf(0f, 0f, 0f)
    ColorUtils.colorToHSL((value shr 32).toInt(), hsl)
    hsl[2] = 1 - hsl[2]
    val colorInt = ColorUtils.HSLToColor(hsl)
    return ComposeColor(colorInt)
}
