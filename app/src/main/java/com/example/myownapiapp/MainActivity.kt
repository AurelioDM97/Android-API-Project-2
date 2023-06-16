package com.example.myownapiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myownapiapp.databinding.ActivityMainBinding
import com.example.myownapiapp.model.CatFactsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CatFactsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[CatFactsViewModel::class.java]

        viewModel.catFact.observe(this) { catFacts ->
            binding.mainText.text = catFacts
        }

        binding.generateButton.setOnClickListener() {
            viewModel.getCatFacts()
        }
    }
}




