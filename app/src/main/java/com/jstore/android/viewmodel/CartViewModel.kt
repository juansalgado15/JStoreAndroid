package com.jstore.android.viewmodel

import androidx.lifecycle.ViewModel
import com.jstore.android.data.model.CartItem
import com.jstore.android.data.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CartViewModel : ViewModel() {

    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems: StateFlow<List<CartItem>> = _cartItems

    fun addToCart(product: Product) {
        val currentItems = _cartItems.value.toMutableList()

        val existingItem = currentItems.find {
            it.product.id == product.id
        }

        if (existingItem != null) {
            val index = currentItems.indexOf(existingItem)

            currentItems[index] = existingItem.copy(
                quantity = existingItem.quantity + 1
            )
        } else {
            currentItems.add(
                CartItem(product = product)
            )
        }

        _cartItems.value = currentItems
    }

    fun removeFromCart(productId: Long) {
        _cartItems.value = _cartItems.value.filter {
            it.product.id != productId
        }
    }

    fun clearCart() {
        _cartItems.value = emptyList()
    }

    fun getTotal(): Double {
        return _cartItems.value.sumOf {
            it.product.price * it.quantity
        }
    }
}