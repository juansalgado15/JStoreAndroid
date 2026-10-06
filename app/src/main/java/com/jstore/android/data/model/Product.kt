package com.jstore.android.data.model

data class Product(
    val id: Long,
    val name: String,
    val description: String?,
    val price: Double,
    val stock: Int,
    val active: Boolean,
    val image: String?
)