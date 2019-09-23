package com.poran.mvvmapp.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.poran.mvvmapp.data.db.AppDatabase
import com.poran.mvvmapp.data.db.entities.Quote
import com.poran.mvvmapp.data.db.preferences.PreferenceProvider
import com.poran.mvvmapp.data.network.MyApi
import com.poran.mvvmapp.data.network.SafeApiRequest
import com.poran.mvvmapp.utils.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

private val MIN_INTERVAL=6
class QuotesRepository (
    private val api:MyApi,
    private val db:AppDatabase,
    private val prefs:PreferenceProvider
):SafeApiRequest() {
    private val quotes=MutableLiveData<List<Quote>>()

    init {
        quotes.observeForever{
            saveQuotes(it)
        }
    }

    suspend fun getQuotes():LiveData<List<Quote>>{
        return  withContext(Dispatchers.IO){
            fetchQuotes()
            db.getQuoteDao().getQuote()
        }
    }
    private suspend fun fetchQuotes(){
        val lastSavedAt=prefs.getLastSavedAt()
        if(lastSavedAt==null||isFetchNeeded(LocalDateTime.parse(lastSavedAt))){
            val response= apiRequest { api.getQuotes() }
            quotes.postValue(response.quotes)
        }
    }

    private fun isFetchNeeded(savedAt: LocalDateTime): Boolean {
        return ChronoUnit.HOURS.between(savedAt,LocalDateTime.now())> MIN_INTERVAL

    }

    private fun saveQuotes(quotes: List<Quote>) {
        Coroutines.io{
            prefs.savelasrSavedAt(LocalDateTime.now().toString())
            db.getQuoteDao().saveAllQuotes(quotes)
        }

    }
}