package com.example.sptrack.design.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import com.example.sptrack.design.shape.LocalShapes

@Composable
fun SPOutlinedTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    label: String,
    trailingIcon: @Composable (() -> Unit)? = null,
    modifier: Modifier =Modifier,
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth().then(modifier),
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        trailingIcon = trailingIcon,
        shape = LocalShapes.current.normal,
//        colors = DesignSystem.customTextFieldColors,
//        border = TextFieldDefaults.outlinedTextFieldBorder(
//            focusedColor = MaterialTheme.colorScheme.primary,
//            unfocusedColor = Color.Gray,
//            errorColor = Color.Red,
//            borderWidth = DesignSystem.textFieldBorderWidth
//        )
    )
}
