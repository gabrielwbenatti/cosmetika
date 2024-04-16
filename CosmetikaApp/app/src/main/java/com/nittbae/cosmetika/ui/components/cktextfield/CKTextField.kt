package com.nittbae.cosmetika.ui.components.cktextfield

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.nittbae.cosmetika.ui.components.base.CKTile

@Composable
fun CKTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: ((String) -> Unit),
    label: String,
    imeAction: ImeAction = ImeAction.Default,
) {
    val typo = MaterialTheme.typography

    CKTile {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = typo.bodyLarge,
            modifier = modifier.defaultMinSize(minWidth = 280.dp, minHeight = 56.dp),
            keyboardOptions = KeyboardOptions(
                imeAction = imeAction
            )
        )
    }
}