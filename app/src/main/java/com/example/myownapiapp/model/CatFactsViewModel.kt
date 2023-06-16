package com.example.myownapiapp.model

import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myownapiapp.ApiInterface
import com.example.myownapiapp.api.CatDataJson
import com.example.myownapiapp.api.CatFactsList
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CatFactsViewModel : ViewModel() {
    private val api: ApiInterface
     val catFact = MutableLiveData<String?>()

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://cat-fact.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(ApiInterface::class.java)
    }
    fun getCatFacts() {
        viewModelScope.launch {
            val response = api.getCatFact()
            val catFacts = response.body()?.text

            catFact.postValue(catFacts)
        }
    }
}