package com.example.sptrack.design

import androidx.compose.runtime.Composable
import com.example.sptrack.design.color.LocalColors
import com.example.sptrack.design.shape.DefaultShapes


import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.text.font.FontFamily
import com.example.sptrack.design.color.SPColors
import com.example.sptrack.design.shape.LocalShapes
import com.example.sptrack.design.shape.SPShapes
import com.example.sptrack.design.typography.LocalTypography
import com.example.sptrack.design.typography.SPFonts
import com.example.sptrack.design.typography.SPTypography
import com.example.sptrack.design.typography.textStyles


@Composable
fun SPTheme(
    shapes: SPShapes = DefaultShapes.default,
    fontFamily: FontFamily = SPFonts,
    colors: SPColors = SPTheme.colors,
    typography: SPTypography = textStyles(),
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalTypography provides typography,
        LocalShapes provides shapes,
    ) {
        content()
    }
}

/**
 * Useful static object to access currently configured Theme properties.
 */
object SPTheme {

    /**
     * These represent the default ease-of-use accessors for colors, typography.
     * */
    val colors: SPColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: SPTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val shapes: SPShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current
}