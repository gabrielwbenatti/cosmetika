package com.nittbae.cosmetika.ui.page.home.products.detail

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import com.nittbae.cosmetika.ui.components.base.CKScaffold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsDetailPage(
    navController: NavController
) {
    CKScaffold(
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(
                        text = "7Belo Body Splash QDB dcd 200ml",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = ""
                        )
                    }
                }
            )
        }
    ) {
        var state by remember { mutableIntStateOf(0) }
        val titles = listOf("Dados", "Valores", "Estoque")

        LazyColumn {
            item {
                PrimaryTabRow(selectedTabIndex = state) {
                    titles.forEachIndexed { index, title ->
                        Tab(
                            selected = index == state,
                            onClick = { state = index },
                            text = { Text(text = title) }
                        )
                    }
                }
            }
        }
    }
}