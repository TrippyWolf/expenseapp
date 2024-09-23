package com.example.sptrack.feature

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sptrack.design.color.LocalColors
import com.example.sptrack.design.components.SPButton
import com.example.sptrack.design.space.Spacing
import com.example.sptrack.ui.component.TitleMedium


@Composable
fun ProfileScreen(onThemeChange: () -> Unit){

    Surface(
        modifier = Modifier.padding(horizontal = Spacing.Spacing_16)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top= 32.dp)
            , // Fill the available size
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            SPButton(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = LocalColors.current.mainColors.violet.violet_100,
                onClick = onThemeChange
            ) {
                TitleMedium(
                    text = "Switch Theme",
                    textColor = LocalColors.current.mainColors.light.light_100
                )
            }

        }
    }
}