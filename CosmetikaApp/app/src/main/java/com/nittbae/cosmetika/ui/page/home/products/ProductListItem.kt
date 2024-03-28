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
    trailing: (@Composable () -> Unit)? = null,
    onClick: () -> Unit = {},
) {
    ListItem(
        headlineContent = { Text(text = headline) },
        supportingText = { if (supportingText != null) Text(text = supportingText) }
    )


    CKSettingListItem(
        modifier,
        headline,
        supportingText,
        leading,
        trailing,
        onClick
    )
}