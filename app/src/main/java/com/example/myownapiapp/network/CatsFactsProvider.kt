package com.example.myownapiapp.network

import androidx.lifecycle.MutableLiveData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CatsFactsProvider {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://cat-fact.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val catApi: CatsFactsApi = retrofit.create(CatsFactsApi::class.java)
}
