package com.example.sptrack.ui.theme

import androidx.compose.runtime.Composable
import com.example.sptrack.design.SPTheme
import com.example.sptrack.design.color.defaultDarkColors
import com.example.sptrack.design.color.defaultLightColors

@Composable
fun SPTrackTheme(
    isLightTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    SPTheme(
        colors = if (isLightTheme) defaultLightColors() else defaultDarkColors(),
    ) {
        content()
    }
}
