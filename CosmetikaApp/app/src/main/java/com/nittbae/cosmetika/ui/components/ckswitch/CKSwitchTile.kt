package com.nittbae.cosmetika.ui.components.ckswitch

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nittbae.cosmetika.ui.components.base.CKTile
import com.nittbae.cosmetika.ui.theme.CosmetikaTheme

@Composable
fun CKSwitchTile(
    modifier: Modifier = Modifier,
    headline: String,
    supportingText: String? = null,
    checked: Boolean,
    onClick: ((Boolean) -> Unit)?
) {
    val colorScheme = MaterialTheme.colorScheme
    val typo = MaterialTheme.typography
    val maxLineHeadline = if (supportingText == null) 2 else 1

    CKTile(
        modifier = modifier.clickable { onClick?.invoke(checked) },
        horizontalArrangement = Arrangement.SpaceBetween,
        color = colorScheme.surfaceContainerLowest
    ) {
        Column {
            Text(
                text = headline,
                maxLines = maxLineHeadline,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = colorScheme.onSurface
                )
            )

            if (supportingText != null)
                Text(
                    text = supportingText,
                    maxLines = 3,
                    style = typo.bodyMedium.copy(
                        color = colorScheme.onSurfaceVariant
                    )
                )
        }

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
                    headline = "Test Enabled",
                    supportingText = "Supporting Text",
                    checked = true,
                    onClick = {}
                )
                CKSwitchTile(
                    headline = "Test Disabled",
                    checked = false,
                    onClick = {}
                )
            }
        }
    }
}