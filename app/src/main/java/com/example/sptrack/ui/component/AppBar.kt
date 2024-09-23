package com.example.sptrack.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TopAppBar(
    content:()->Unit
){
    Row(
        modifier = Modifier.fillMaxWidth().height(70.dp)
    ){
      content()
    }

}