package com.poran.mvvmapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poran.mvvmapp.data.db.entities.Quote


@Dao
interface QuoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  saveAllQuotes(quotes :List<Quote>)

    @Query("SELECT * FROM Quote")
    fun getQuote():LiveData<List<Quote>>
}