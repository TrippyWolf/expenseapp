package com.example.sptrack.design.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SPListItemContent(
    modifier: Modifier = Modifier,
    composable1: @Composable () -> Unit,
    composable2: @Composable () -> Unit,
) {
    Column(modifier = modifier) {
        composable1()
        composable2()
    }
}
