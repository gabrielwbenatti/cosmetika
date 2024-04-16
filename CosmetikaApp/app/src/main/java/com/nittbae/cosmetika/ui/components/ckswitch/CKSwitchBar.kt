package com.nittbae.cosmetika.ui.components.ckswitch

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.nittbae.cosmetika.ui.components.base.CKTile
import com.nittbae.cosmetika.ui.theme.CosmetikaTheme

@Composable
fun CKSwitchBar(
    modifier: Modifier = Modifier,
    labelChecked: String,
    labelUnchecked: String,
    checked: Boolean,
    onClick: ((Boolean) -> Unit)?
) {
    val colorScheme = MaterialTheme.colorScheme
    val typo = MaterialTheme.typography

    val bgColor: Color
    val txtStyle: TextStyle
    val txtLabel: String

    if (checked) {
        txtLabel = labelChecked
        bgColor = colorScheme.surfaceContainerHigh
        txtStyle = typo.bodyLarge.copy(
            fontWeight = FontWeight.Bold,
            color = colorScheme.onSurfaceVariant
        )
    } else {
        txtLabel = labelUnchecked
        bgColor = colorScheme.surfaceContainerLowest
        txtStyle = typo.bodyLarge.copy(fontWeight = FontWeight.Bold)
    }

    CKTile(
        modifier = modifier.clickable { onClick?.invoke(checked) },
        horizontalArrangement = Arrangement.SpaceBetween,
        color = bgColor
    ) {
        Text(
            text = txtLabel,
            style = txtStyle,
        )
        Switch(checked = checked, onCheckedChange = onClick)
    }
}

@Preview
@Composable
private fun PrevCKSwitchTile() {
    CosmetikaTheme(dynamicColor = false) {
        LazyColumn {
            item {
                CKSwitchBar(
                    labelChecked = "Enabled",
                    labelUnchecked = "Disabled",
                    checked = true,
                    onClick = {}
                )
                CKSwitchBar(
                    labelChecked = "Enabled",
                    labelUnchecked = "Disabled",
                    checked = false,
                    onClick = {}
                )
            }
        }
    }
}