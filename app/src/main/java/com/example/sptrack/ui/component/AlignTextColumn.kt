package com.example.sptrack.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun AlignTextColumns(
    modifier: Modifier = Modifier,
    margin: Dp = 8.dp,
    text1: @Composable () -> Unit,
    text2: @Composable () -> Unit,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start
    ) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = horizontalAlignment,
    ) {
        text1()
        Spacer(modifier = Modifier.height(margin))
        text2()
    }
}
