package com.example.randomquotes.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.randomquotes.data.model.Quote
import com.example.randomquotes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.quoteLiveDate.observe(this) { result ->
            when (result) {
                is MainViewModel.Loading -> showLoading()
                is MainViewModel.Error -> showError()
                is MainViewModel.Success -> showQuote(result.data)
            }
        }

        binding.btnUpdate.setOnClickListener { viewModel.updateRandomQuote() }
    }

    private fun showQuote(data: Quote) {
        hideLoading()
        binding.tvAuthor.text = data.author
        binding.tvQuote.text = data.message
    }

    private fun showError() {
        hideLoading()
        Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
    }

    private fun showLoading() {
        binding.tvAuthor.text = null
        binding.tvQuote.text = null
        binding.progressbar.isVisible = true
    }

    private fun hideLoading() {
        binding.progressbar.isVisible = false
    }
}