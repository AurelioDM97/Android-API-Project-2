package com.example.myownapiapp

import com.example.myownapiapp.api.CatDataJson
import com.example.myownapiapp.api.CatFactsList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/facts/random")
     suspend fun getCatFact() : Response<CatDataJson>

}