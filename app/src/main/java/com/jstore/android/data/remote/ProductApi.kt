package com.jstore.android.data.remote

import com.jstore.android.data.model.Product
import retrofit2.http.GET

interface ProductApi {

    @GET("api/products")
    suspend fun getProducts(): List<Product>
}