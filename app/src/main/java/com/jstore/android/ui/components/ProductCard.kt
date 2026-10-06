package com.jstore.android.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jstore.android.data.model.Product

@Composable
fun ProductCard(
    product: Product,
    onAddToCart: (Product) -> Unit = {}
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = product.name,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = product.description ?: "Sin descripción",
                modifier = Modifier.padding(top = 8.dp)
            )

            Text(
                text = "$${product.price}",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(top = 8.dp)
            )

            Text(
                text = "Stock: ${product.stock}",
                modifier = Modifier.padding(top = 4.dp)
            )

            Button(
                onClick = {
                    onAddToCart(product)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text(text = "Agregar al carrito")
            }
        }
    }
}