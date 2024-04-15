package com.nittbae.cosmetika.ui.page.home.products

import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ProductListItem(
    modifier: Modifier = Modifier,
    headline: String,
    supportingText: String? = null,
    leading: (@Composable () -> Unit)? = null,
    onClick: () -> Unit = {},
    trailing: (@Composable () -> Unit)? = null,
) {
    CKSettingListItem(
        modifier,
        headline,
        supportingText,
        leading,
        onClick
    ) {
        trailing?.invoke()
    }
}