package com.nittbae.cosmetika.ui.components.base

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nittbae.cosmetika.ui.theme.CKLayout

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CKScaffold(
    navigationIcon: (@Composable () -> Unit)? = null,
    actions: (@Composable () -> Unit)? = null,
    bottomBar: (@Composable () -> Unit)? = null,
    topBar: (@Composable () -> Unit)? = null,
    floatingActionButton: (@Composable () -> Unit)? = null,
    content: @Composable () -> Unit = {}
) {
    Scaffold(
        topBar = {
            if (topBar != null) {
                topBar.invoke()
            } else if (navigationIcon != null || actions != null) {
                TopAppBar(
                    title = {},
                    navigationIcon = { navigationIcon?.invoke() },
                    actions = { actions?.invoke() }
                )
            }
        },
        bottomBar = { bottomBar?.invoke() },
        floatingActionButton = { floatingActionButton?.invoke() },
        containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
    ) { paddingValues ->
        Column {
            Spacer(modifier = Modifier.height(paddingValues.calculateTopPadding()))
            content()

            Spacer(modifier = Modifier.height(CKLayout.H_PADDING))
        }
    }
}