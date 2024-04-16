package com.nittbae.cosmetika.ui.components.base

import androidx.compose.foundation.hoverable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.nittbae.cosmetika.ui.theme.CKLayout

@Composable
fun CKTile(
        modifier: Modifier = Modifier,
        horizontalArrangement: Arrangement.Horizontal = Arrangement.SpaceBetween,
        verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
        color: Color = MaterialTheme.colorScheme.surfaceContainerLowest,
        content: @Composable RowScope.() -> Unit
) {
    Surface(color = color) {
        Row(
                modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = CKLayout.H_PADDING, vertical = CKLayout.V_PADDING),
                horizontalArrangement = horizontalArrangement,
                verticalAlignment = verticalAlignment,
        ) {
            content()
        }
    }


}