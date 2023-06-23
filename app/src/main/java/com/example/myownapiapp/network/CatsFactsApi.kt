package com.example.myownapiapp.network

import com.example.myownapiapp.network.data.CatData
import retrofit2.Response
import retrofit2.http.GET

interface CatsFactsApi {
    @GET("/facts/random")
     suspend fun getCatFact() : Response<CatData>
}