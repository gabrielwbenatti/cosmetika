package com.nittbae.cosmetika.ui.components.base

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.nittbae.cosmetika.ui.theme.CKLayout

@Composable
fun CKOutlinedTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    trailingIcon: (@Composable () -> Unit)? = null,
    imeAction: ImeAction = ImeAction.Default,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        modifier = modifier
            .padding(horizontal = CKLayout.H_PADDING, vertical = CKLayout.H_PADDING / 4),
        label = { Text(text = label) },
        value = value,
        trailingIcon = trailingIcon,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(
            imeAction = imeAction
        )
    )
}