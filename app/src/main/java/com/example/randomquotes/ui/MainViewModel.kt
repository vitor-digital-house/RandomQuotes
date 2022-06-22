package com.example.randomquotes.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomquotes.data.model.Quote
import com.example.randomquotes.data.QuoteRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _quoteLiveData = MutableLiveData<Result>()
    val quoteLiveDate: LiveData<Result> = _quoteLiveData
    private val repository: QuoteRepository = QuoteRepository()

    init {
        updateRandomQuote()
    }

    fun updateRandomQuote() {
        _quoteLiveData.value = Loading

        viewModelScope.launch {
            val quote = repository.getRandomQuote()
            _quoteLiveData.value = Success(quote)
        }
    }

    sealed class Result
    object Loading : Result()
    data class Success(val data: Quote) : Result()
    object Error : Result()
}