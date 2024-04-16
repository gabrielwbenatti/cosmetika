package com.nittbae.cosmetika.ui.components.ckdivider

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.nittbae.cosmetika.ui.theme.CKLayout

@Composable
fun CKHorizontalDivider(
    modifier: Modifier = Modifier,
    padding: Dp = CKLayout.H_PADDING
) {
    HorizontalDivider(
        modifier = modifier.padding(horizontal = padding)
    )
}