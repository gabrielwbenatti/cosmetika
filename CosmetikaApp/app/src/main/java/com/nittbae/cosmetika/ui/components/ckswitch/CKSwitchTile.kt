package com.nittbae.cosmetika.ui.components.ckswitch

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nittbae.cosmetika.ui.components.base.CKTile
import com.nittbae.cosmetika.ui.theme.CosmetikaTheme

@Composable
fun CKSwitchTile(
    modifier: Modifier = Modifier,
    label: String,
    checked: Boolean,
    onClick: ((Boolean) -> Unit)?
) {
    val colorScheme = MaterialTheme.colorScheme

    CKTile(
        modifier = modifier.clickable { onClick?.invoke(checked) },
        horizontalArrangement = Arrangement.SpaceBetween,
        color = colorScheme.surfaceContainerLowest
    ) {
        Text(text = label, style = MaterialTheme.typography.bodyLarge)
        Switch(checked = checked, onCheckedChange = onClick)
    }
}

@Preview
@Composable
private fun PrevCKSwitchTile() {
    CosmetikaTheme(dynamicColor = false) {
        LazyColumn {
            item {
                CKSwitchTile(
                    label = "Test Enabled",
                    checked = true,
                    onClick = {}
                )
                CKSwitchTile(
                    label = "Test Disabled",
                    checked = false,
                    onClick = {}
                )
            }
        }
    }
}