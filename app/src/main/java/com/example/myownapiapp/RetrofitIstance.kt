package com.example.myownapiapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitIstance {

    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://cat-fact.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    val apiInterface: ApiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }
}

