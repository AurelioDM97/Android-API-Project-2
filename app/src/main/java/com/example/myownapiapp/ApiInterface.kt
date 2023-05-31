package com.example.myownapiapp

import com.example.myownapiapp.api.CatDataJson
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("/facts/random")
     suspend fun getCatFacts() : CatDataJson

}