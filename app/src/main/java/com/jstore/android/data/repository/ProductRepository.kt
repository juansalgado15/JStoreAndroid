package com.jstore.android.data.repository

import com.jstore.android.data.model.Product
import com.jstore.android.data.remote.ProductApi

class ProductRepository(
    private val api: ProductApi
) {

    suspend fun getProducts(): List<Product> {
        return api.getProducts()
    }
}