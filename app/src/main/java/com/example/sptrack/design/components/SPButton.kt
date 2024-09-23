package com.example.sptrack.design.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Indication
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding

import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.sptrack.design.color.LocalColors
import com.example.sptrack.design.shape.LocalShapes

import androidx.compose.ui.graphics.Color as ComposeColor

@Composable
fun SPButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: ComposeColor = LocalColors.current.contentColors.normal,
    contentColor: ComposeColor = LocalColors.current.contentColors.normal,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    indication: Indication? = rememberRipple(),
    elevation: ButtonElevation = ButtonDefaults.elevatedButtonElevation(),
    shape: Shape = LocalShapes.current.normal,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit
) {
    SPSurface(
        modifier = modifier,
        shape = shape,
        color = backgroundColor,
        border = border,
        onClick = onClick,
        role = Role.Button,
        interactionSource = interactionSource,
        indication = indication
    ) {
        Row(
            Modifier
                .defaultMinSize(
                    minWidth = ButtonDefaults.MinWidth,
                    minHeight = ButtonDefaults.MinHeight
                )
                .padding(contentPadding),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            content = content
        )
    }
}



