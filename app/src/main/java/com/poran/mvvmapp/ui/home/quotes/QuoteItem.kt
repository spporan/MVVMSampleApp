package com.poran.mvvmapp.ui.home.quotes

import com.poran.mvvmapp.R
import com.poran.mvvmapp.data.db.entities.Quote
import com.poran.mvvmapp.databinding.QuotesItemBinding
import com.xwray.groupie.databinding.BindableItem

class QuoteItem (

    private val quote:Quote
):BindableItem<QuotesItemBinding>(){

    override fun getLayout()=R.layout.quotes_item

    override fun bind(viewBinding: QuotesItemBinding, position: Int) {
        viewBinding.setQuote(quote)

    }
}