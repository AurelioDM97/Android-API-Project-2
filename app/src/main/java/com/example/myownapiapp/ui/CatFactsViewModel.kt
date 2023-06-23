package com.example.myownapiapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myownapiapp.network.CatsFactsApi
import com.example.myownapiapp.network.CatsFactsProvider
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CatFactsViewModel : ViewModel() {

    val catFact = MutableLiveData<String?>()
    fun getCatFacts() {
        viewModelScope.launch {
            val response = CatsFactsProvider().catApi.getCatFact()
            val catFacts = response.body()?.text
            catFact.postValue(catFacts)
        }
    }
}