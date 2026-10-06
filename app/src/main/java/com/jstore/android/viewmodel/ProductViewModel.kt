package com.jstore.android.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jstore.android.data.model.Product
import com.jstore.android.data.remote.RetrofitInstance
import com.jstore.android.data.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {

    private val repository = ProductRepository(RetrofitInstance.api)

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun loadProducts() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null

            try {
                _products.value = repository.getProducts()
            } catch (e: Exception) {
                _error.value = e.message ?: "Error al cargar los productos"
            } finally {
                _isLoading.value = false
            }
        }
    }
}