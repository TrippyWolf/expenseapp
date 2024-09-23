package com.example.sptrack.design.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sptrack.design.SPTheme
import com.example.sptrack.design.shape.SPShapes

// Card Component for Design System
@Composable
fun SPCard(
    modifier: Modifier = Modifier,
    backgroundColor: Color = SPTheme.colors.primaryColors.background,
    contentColor: Color = Color.Black,
    shape: Shape = SPTheme.shapes.large,
    borderStroke: BorderStroke? = null,
    content: @Composable () -> Unit,
) {
    Card(
        shape = shape,
        modifier = modifier,
        border = borderStroke,
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor, // Set background color here
        )
    ) {
        content()
    }
}
