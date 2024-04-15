package com.nittbae.cosmetika.ui.components.base

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nittbae.cosmetika.ui.theme.CKLayout

@Composable
fun CKOutlinedTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        modifier = modifier.padding(horizontal = CKLayout.H_PADDING, vertical = CKLayout.V_PADDING / 3),
        label = { Text(text = label) },
        value = value,
        onValueChange = onValueChange
    )
}