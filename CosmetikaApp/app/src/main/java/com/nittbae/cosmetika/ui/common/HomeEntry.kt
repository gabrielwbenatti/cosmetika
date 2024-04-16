package com.nittbae.cosmetika.ui.common

import androidx.compose.runtime.Composable
import androidx.core.view.KeyEventDispatcher.Component
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nittbae.cosmetika.ui.page.components.ComponentsPage
import com.nittbae.cosmetika.ui.theme.CosmetikaTheme
import com.nittbae.cosmetika.ui.page.home.products.ProductsPage
import com.nittbae.cosmetika.ui.page.home.products.detail.ProductsDetailPage

@Composable
fun HomeEntry() {
    val navController = rememberNavController()

    CosmetikaTheme {
        NavHost(
            navController = navController,
            startDestination = RouteName.PRODUCTS
        ) {
            composable(route = RouteName.PRODUCTS) {  ProductsPage(navController)   }
            composable(route = RouteName.PRODUCTS_DETAIL) {  ProductsDetailPage(navController)   }
            composable(route = RouteName.COMPONENTS) {  ComponentsPage(navController)   }
        }
    }
}