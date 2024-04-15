package com.nittbae.cosmetika.ui.components.base

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.nittbae.cosmetika.ui.theme.CKLayout

@Composable
fun CKSubtitle(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.primary
) {
    Text(
        text = text,
        modifier = modifier
            .padding(
                start = CKLayout.H_PADDING,
                top = CKLayout.V_PADDING,
                end = CKLayout.H_PADDING,
                bottom = CKLayout.V_PADDING / 3
            ),
        color = color,
        style = MaterialTheme.typography.labelLarge
    )
}