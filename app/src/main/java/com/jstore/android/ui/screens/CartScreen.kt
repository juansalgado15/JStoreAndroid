package com.jstore.android.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jstore.android.viewmodel.CartViewModel

@Composable
fun CartScreen(
    cartViewModel: CartViewModel = viewModel()
) {
    val cartItems by cartViewModel.cartItems.collectAsState()

    if (cartItems.isEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "El carrito está vacío",
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                text = "Agrega productos desde el catálogo.",
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Carrito de compras",
                style = MaterialTheme.typography.headlineSmall
            )

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(cartItems) { item ->
                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = item.product.name,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Text(
                                text = "Cantidad: ${item.quantity}",
                                modifier = Modifier.padding(top = 4.dp)
                            )

                            Text(
                                text = "Precio: $${item.product.price}",
                                modifier = Modifier.padding(top = 4.dp)
                            )

                            Text(
                                text = "Subtotal: $${item.product.price * item.quantity}",
                                modifier = Modifier.padding(top = 4.dp)
                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp),
                                horizontalArrangement = Arrangement.End
                            ) {
                                Button(
                                    onClick = {
                                        cartViewModel.removeFromCart(item.product.id)
                                    }
                                ) {
                                    Text(text = "Eliminar")
                                }
                            }
                        }
                    }
                }
            }

            Text(
                text = "Total: $${cartViewModel.getTotal()}",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(vertical = 12.dp)
            )

            Button(
                onClick = {
                    cartViewModel.clearCart()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Vaciar carrito")
            }
        }
    }
}