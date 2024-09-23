package com.example.sptrack.design.typography

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.text.TextStyle


class SPTypography(
    val titleXLargeTypographyStyle: TextStyle,
    val titleLargeTypographyStyle: TextStyle,
    val titleMediumTypographyStyle: TextStyle,
    val titleSmallTypographyStyle: TextStyle,
    val bodyXLargeTypographyStyle: TextStyle,
    val bodyLargeTypographyStyle: TextStyle,
    val bodyMediumTypographyStyle: TextStyle,
    val bodySmallTypographyStyle: TextStyle,
    val bodyXSmallTypographyStyle: TextStyle,

    )

/**
 * Builds the default typography set for our theme.
 * */
@Composable
fun textStyles(): SPTypography {
    return SPTypography(
        titleXLargeTypographyStyle = TitleXLargeTypographyStyle()
            .getComposeTextStyle(),
        titleLargeTypographyStyle = TitleLargeTypographyStyle()
            .getComposeTextStyle(),
        titleMediumTypographyStyle = TitleMediumTypographyStyle()
            .getComposeTextStyle(),
        titleSmallTypographyStyle = TitleSmallTypographyStyle()
            .getComposeTextStyle(),
        bodyXLargeTypographyStyle = BodyXLargeTypographyStyle()
            .getComposeTextStyle(),
        bodyLargeTypographyStyle = BodyLargeTypographyStyle()
            .getComposeTextStyle(),
        bodyMediumTypographyStyle = BodyMediumTypographyStyle()
            .getComposeTextStyle(),
        bodySmallTypographyStyle = BodySmallTypographyStyle()
            .getComposeTextStyle(),
        bodyXSmallTypographyStyle = BodyXSmallTypographyStyle()
            .getComposeTextStyle(),

        )
}

private fun toTextStyle(typographyStyle: BaseTypography): TextStyle {
    return TextStyle(
        fontSize = typographyStyle.fontSize,
        fontFamily = typographyStyle.fontFamily,
        lineHeight = typographyStyle.lineHeight,
        fontWeight = typographyStyle.fontWeight,
    )
}

fun BaseTypography.getComposeTextStyle(): TextStyle {
    return toTextStyle(this)
}

internal val LocalTypography = compositionLocalOf<SPTypography> {
    error(
        "No typography provided! Make sure to wrap all usages of components in a " +
                "AndromedaTheme."
    )
}