package com.nittbae.cosmetika.ui.components.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.nittbae.cosmetika.ui.theme.CKLayout

@Composable
fun CKGroupItems(
    groupTitle: (@Composable () -> Unit)? = null,
    surfaceColor: Color? = null,
    content: @Composable () -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme

    Column {
        groupTitle?.invoke()
        Box(modifier = Modifier.height(CKLayout.V_PADDING / 3))
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(CKLayout.H_PADDING)),
            color = surfaceColor ?: colorScheme.surfaceContainerLowest
        ) {
            Column {
                content()
            }
        }
    }
}
