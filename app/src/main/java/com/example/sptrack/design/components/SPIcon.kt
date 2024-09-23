package com.example.sptrack.design.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toolingGraphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.sptrack.design.SPTheme
import com.example.sptrack.design.conditional

enum class IconSize(val size: Int) {
    SMALL(24),   // Size in dp or any unit
    MEDIUM(48),
    LARGE(96)
}

@Composable
fun SPIcon(
    painter: Painter,
    contentDescription: String? = "",
    modifier: Modifier = Modifier,
    onClick: IconClickHandler? = null,
    tint: Color = SPTheme.colors.contentColors.normal,
    iconSize: IconSize = IconSize.SMALL,
) {
    val colorFilter = if (tint == Color.Unspecified) null else ColorFilter.tint(tint)
    val semantics = if (contentDescription != null) {
        Modifier.semantics {
            this.contentDescription = contentDescription
            this.role = Role.Image
        }
    } else {
        Modifier
    }
    val iconClickRipple = rememberRipple(
        bounded = false,
        color = SPTheme.colors.contentColors.normal
    )
    val interactionSource = remember {
        MutableInteractionSource()
    }

    Box(
        modifier
            .toolingGraphicsLayer()
            .iconSizeFor(iconSize)
            .paint(
                painter,
                colorFilter = colorFilter,
                contentScale = ContentScale.Fit
            )
            .then(semantics)
            .conditional(onClick != null) {
                Modifier.clickable(
                    onClick = onClick!!,
                    indication = iconClickRipple,
                    interactionSource = interactionSource
                )
            }
    )
}

@Composable
fun SPIcon(
    imageVector: ImageVector,
    contentDescription: String? = "",
    modifier: Modifier = Modifier,
    onClick: IconClickHandler? = null,
    tint: Color = SPTheme.colors.contentColors.normal,
    iconSize: IconSize = IconSize.SMALL,
) {
    val colorFilter = if (tint == Color.Unspecified) null else ColorFilter.tint(tint)
    val semantics = if (contentDescription != null) {
        Modifier.semantics {
            this.contentDescription = contentDescription
            this.role = Role.Image
        }
    } else {
        Modifier
    }
    val iconClickRipple = rememberRipple(
        bounded = false,
        color = SPTheme.colors.contentColors.normal
    )
    val interactionSource = remember {
        MutableInteractionSource()
    }

    Box(
        modifier
            .toolingGraphicsLayer()
            .iconSizeFor(iconSize)
            .paint(
                rememberVectorPainter(imageVector),
                colorFilter = colorFilter,
                contentScale = ContentScale.Fit
            )
            .then(semantics)
            .conditional(onClick != null) {
                Modifier.clickable(
                    onClick = onClick!!,
                    indication = iconClickRipple,
                    interactionSource = interactionSource
                )
            }
    )
}

private fun Modifier.iconSizeFor(iconSize: IconSize) =
    this.then(
        Modifier.size(iconSize.size.dp)
    )

typealias IconClickHandler = () -> Unit
