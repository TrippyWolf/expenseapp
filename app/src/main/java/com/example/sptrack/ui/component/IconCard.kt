package com.example.sptrack.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.sptrack.design.components.IconSize
import com.example.sptrack.design.components.SPCard
import com.example.sptrack.design.components.SPIcon

@Composable
fun IconCard(
    resourceId: Int,
    contentDescription: String,
    iconTint: Color,
    backGroundColor: Color,
    iconSize: IconSize,
    modifier: Modifier =Modifier
) {
    SPCard(
        backgroundColor = backGroundColor,
        modifier = modifier
    ) {
        Box(
            modifier = modifier, // Ensures the icon is centered in the SPCard
            contentAlignment = Alignment.Center // Centers the icon within the card
        ) {
            SPIcon(
                painter = painterResource(resourceId),
                contentDescription = contentDescription,
                tint = iconTint,
                iconSize = iconSize
            )
        }
    }
}

