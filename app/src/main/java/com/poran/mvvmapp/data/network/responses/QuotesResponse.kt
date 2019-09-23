package com.poran.mvvmapp.data.network.responses

import com.poran.mvvmapp.data.db.entities.Quote

data class QuotesResponse (
    val isSuccessful:Boolean,
    val quotes:List<Quote>
)