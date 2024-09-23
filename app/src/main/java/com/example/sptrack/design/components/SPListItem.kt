package com.example.sptrack.design.components


import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SPListItem(
    modifier: Modifier = Modifier,
    composable1: @Composable () -> Unit,
    composable2: @Composable () -> Unit,
    composable3: @Composable () -> Unit
) {
    Row(modifier = modifier) {
        composable1()
        composable2()
        composable3()
    }
}
