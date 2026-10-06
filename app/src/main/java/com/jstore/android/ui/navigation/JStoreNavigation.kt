package com.jstore.android.ui.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jstore.android.ui.screens.CartScreen
import com.jstore.android.ui.screens.ProductScreen
import com.jstore.android.viewmodel.CartViewModel

@Composable
fun JStoreNavigation() {

    val navController = rememberNavController()

    val cartViewModel: CartViewModel = viewModel()

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    navController.navigate("products")
                }
            ) {
                Text(text = "Catálogo")
            }

            Button(
                onClick = {
                    navController.navigate("cart")
                }
            ) {
                Text(text = "Carrito")
            }
        }

        NavHost(
            navController = navController,
            startDestination = "products",
            modifier = Modifier.weight(1f)
        ) {
            composable("products") {
                ProductScreen(
                    cartViewModel = cartViewModel
                )
            }

            composable("cart") {
                CartScreen(
                    cartViewModel = cartViewModel
                )
            }
        }
    }
}