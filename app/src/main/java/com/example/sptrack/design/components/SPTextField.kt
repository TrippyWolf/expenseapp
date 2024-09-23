package com.example.sptrack.design.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import com.example.sptrack.design.components.text.SPText
import com.example.sptrack.design.typography.LocalTypography

@Composable
fun SPTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,

        onValueChange = onValueChange,
        label = { SPText(label) },
        textStyle = LocalTypography.current.titleLargeTypographyStyle,
        prefix = { SPText("$")},
                colors = TextFieldDefaults.colors(
                // Transparent underline colors to effectively remove them
                focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        focusedContainerColor = Color.Transparent,
    ),
        keyboardOptions =keyboardOptions,



    )
}