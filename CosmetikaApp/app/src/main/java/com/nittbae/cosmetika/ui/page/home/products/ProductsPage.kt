package com.nittbae.cosmetika.ui.page.home.products

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nittbae.cosmetika.ui.common.RouteName
import com.nittbae.cosmetika.ui.components.base.CKScaffold
import com.nittbae.cosmetika.ui.components.base.CKSubtitle

@Composable
fun ProductsPage(
    navController: NavController
) {
    CKScaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(text = "Novo Produto") },
                icon = { Icon(imageVector = Icons.Default.Add, contentDescription = "") },
                onClick = { }
            )
        }
    ) {
        LazyColumn {
            item {
                CKSubtitle(
                    text = "${3} produtos cadastrados"
                )
            }
            item {
                ProductListItem(
                    modifier = Modifier.padding(horizontal = 24.dp),
                    headline = "7Belo Body Splash QDB 200ml",
                    supportingText = "Perfumaria",
                    trailing = { Text(text = "62,90") },
                    leading = { Icon(imageVector = Icons.Default.Build, contentDescription = "") },
                    onClick = { navController.navigate(RouteName.PRODUCTS_DETAIL) }
                )
            }
        }
    }
}
