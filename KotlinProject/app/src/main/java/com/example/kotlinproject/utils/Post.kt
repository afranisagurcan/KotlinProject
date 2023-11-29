package com.example.kotlinproject.utils

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("id")
    val id_: Int = 0,
    @SerializedName("title")
    val title: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("price")
    val price:  Double = 0.0,
    @SerializedName("image")
    val image: String = "",
    @SerializedName("brand")
    val brand: String = "",
    @SerializedName("category")
    val category: String = "",
){}
