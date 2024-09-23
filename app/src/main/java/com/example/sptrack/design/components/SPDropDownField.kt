package com.example.sptrack.design.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp


@Composable
fun SPDropdownMenu(
    items: List<String>,
    initialItem: String? = null,
    onItemChanged: (String) -> Unit,
    label: String = "",
    modifier: Modifier = Modifier
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    var expanded by remember { mutableStateOf(false) }
    var textValue by remember { mutableStateOf(initialItem) }

    SPClickableOverlay(
        modifier = modifier,
        onClick = {
            expanded = !expanded
            keyboardController?.hide()
        },
    ) {
        SPOutlinedTextField(
            value = TextFieldValue(textValue ?: ""),
            onValueChange = { textValue = it.text },
            label = label,
            trailingIcon = {
                SPIcon(
                    imageVector = (Icons.Default.ArrowDropDown)

                )
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(24.dp, 0.dp)
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = { Text(text = item) },
                    onClick = {
                        expanded = false
                        textValue = item
                        onItemChanged(item)
                    }
                )
            }
        }
    }
}