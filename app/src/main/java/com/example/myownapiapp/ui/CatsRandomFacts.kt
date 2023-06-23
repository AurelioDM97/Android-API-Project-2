package com.example.myownapiapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.myownapiapp.databinding.ActivityMainBinding

class CatsRandomFacts : AppCompatActivity() {

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




