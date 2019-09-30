package com.laine.mauro.koindemo.presenter

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.laine.mauro.koindemo.R
import com.laine.mauro.koindemo.model.MyCurrency
import kotlinx.android.synthetic.main.view_currency.view.*

class CurrencyView constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    LinearLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.view_currency, this)
    }

    fun setCurrency(currency: MyCurrency) {
        text_name.text = currency.name
        text_symbol.text = currency.symbol
        setOnClickListener {

        }
    }
}