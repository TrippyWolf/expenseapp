package com.example.sptrack.design.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.sptrack.design.typography.LocalTypography

@Composable
fun SPChip(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = Color.White,
    borderWidth: Dp = 0.dp,
    borderColor: Color = Color.Gray,
) {
    Text(
        text = text,
        modifier = modifier
            .background(
                color = contentColor,
                shape = RoundedCornerShape(20.dp)
            )
            .clickable(onClick = onClick)
            .border(
                width = borderWidth,
                color = borderColor,
                shape = RoundedCornerShape(20.dp) // Match the shape of the background
            )
            .padding(horizontal = 16.dp, vertical = 8.dp),
        color = backgroundColor,
        style = LocalTypography.current.bodyXSmallTypographyStyle
    )
}
