package com.example.sptrack.design.color

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.structuralEqualityPolicy

@Stable
class SPColors(
    val mainColors: MainColors,
    val primaryColors: SPPrimaryColors,
    val secondaryColors: SPSecondaryColors,
    val tertiaryColors: SPTertiaryColors,
    val borderColors: BorderColors,
    val iconColors: IconColors,
    val contentColors: ContentColors,
    isDark: Boolean
) {
    var isDark: Boolean by mutableStateOf(isDark, structuralEqualityPolicy())
        internal set

    fun copy(
        mainColors: MainColors=this.mainColors,
        primaryColors: SPPrimaryColors = this.primaryColors,
        secondaryColors: SPSecondaryColors = this.secondaryColors,
        tertiaryColors: SPTertiaryColors = this.tertiaryColors,
        borderColors: BorderColors = this.borderColors,
        iconColors: IconColors = this.iconColors,
        contentColors: ContentColors = this.contentColors,
        isDark: Boolean = this.isDark
    ): SPColors = SPColors(
        mainColors = mainColors,
        primaryColors = primaryColors,
        secondaryColors = secondaryColors,
        tertiaryColors = tertiaryColors,
        borderColors = borderColors,
        iconColors = iconColors,
        contentColors = contentColors,
        isDark = isDark
    )
}

/**
 * Local Andromeda Colors.
 *
 * Access the colors through [SPTheme.colors]
 */
internal val LocalColors: ProvidableCompositionLocal<SPColors> =
    compositionLocalOf { defaultLightColors() }
