package com.example.sptrack.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.sptrack.design.components.text.SPText
import com.example.sptrack.design.typography.LocalTypography


@Composable
fun TitleX(text: String, textColor: Color? = null) {
    SPText(
        text = text,
        color = textColor,
        style = LocalTypography.current.titleXLargeTypographyStyle
    )
}

@Composable
fun TitleLarge(text: String, textColor: Color? = null) {
    SPText(
        text = text,
        color = textColor,
        style = LocalTypography.current.titleLargeTypographyStyle
    )
}

@Composable
fun TitleMedium(text: String, textColor: Color? = null) {
    SPText(
        text = text,
        color = textColor,
        style = LocalTypography.current.titleMediumTypographyStyle
    )
}

@Composable
fun TitleSmall(text: String, textColor: Color? = null) {
    SPText(
        text = text,
        color = textColor,
        style = LocalTypography.current.titleSmallTypographyStyle
    )
}

@Composable
fun BodyXLarge(text: String, textColor: Color? = null) {
    SPText(
        text = text,
        color = textColor,
        style = LocalTypography.current.bodyXLargeTypographyStyle
    )
}

@Composable
fun BodyLarge(text: String, textColor: Color? = null) {
    SPText(
        text = text,
        color = textColor,
        style = LocalTypography.current.bodyLargeTypographyStyle
    )
}


@Composable
fun BodyMedium(text: String, textColor: Color? = null) {
    SPText(
        text = text,
        color = textColor,
        style = LocalTypography.current.bodyMediumTypographyStyle
    )
}


@Composable
fun BodySmall(text: String, textColor: Color? = null) {
    SPText(
        text = text,
        color = textColor,
        style = LocalTypography.current.bodySmallTypographyStyle
    )
}


@Composable
fun BodyXSmall(text: String, textColor: Color? = null) {
    SPText(
        text = text,
        color = textColor,
        style = LocalTypography.current.bodyXSmallTypographyStyle
    )
}