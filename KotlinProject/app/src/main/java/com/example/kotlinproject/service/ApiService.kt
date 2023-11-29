package com.example.kotlinproject.service

import com.example.kotlinproject.utils.Post
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("all")
    fun getProducts(): Call<List<Post>>

}