package com.example.myownapiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.myownapiapp.api.CatDataJson
import com.example.myownapiapp.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getCatFacts()

        binding.generateButton.setOnClickListener {
            getCatFacts()
        }
    }

    private fun getCatFacts() {
        lifecycleScope.launch {
            try {
                val response = RetrofitIstance.apiInterface.getCatFacts()
                binding.mainText.text = response.text
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, "Something went wrong...", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


