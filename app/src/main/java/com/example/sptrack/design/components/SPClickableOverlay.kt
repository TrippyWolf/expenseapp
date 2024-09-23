package com.example.sptrack.design.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SPClickableOverlay(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    content: @Composable BoxScope.() -> Unit
) {
    Box(modifier = modifier) {
        content()
        Box(
            modifier = Modifier
                .matchParentSize()
                .clickable { onClick() }
        )
    }

}