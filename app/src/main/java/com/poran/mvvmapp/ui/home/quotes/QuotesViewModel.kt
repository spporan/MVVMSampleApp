package com.poran.mvvmapp.ui.home.quotes

import androidx.lifecycle.ViewModel
import com.poran.mvvmapp.data.repositories.QuotesRepository
import com.poran.mvvmapp.utils.lazyDeffered

class QuotesViewModel(

    repository: QuotesRepository

) : ViewModel() {

  val quotes by lazyDeffered {
      repository.getQuotes()
  }
}
