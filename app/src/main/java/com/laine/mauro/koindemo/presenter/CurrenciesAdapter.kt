package com.laine.mauro.koindemo.presenter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.laine.mauro.koindemo.R
import com.laine.mauro.koindemo.presenter.CurrenciesAdapter.ViewHolder
import com.laine.mauro.koindemo.model.MyCurrency

class CurrenciesAdapter : RecyclerView.Adapter<ViewHolder>() {

    var currencies: List<MyCurrency>? = listOf<MyCurrency>()

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_currency, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return currencies?.size ?: 0
    }

    override fun onBindViewHolder(view: ViewHolder, position: Int) {
        view.bindData(currencies?.get(position))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name: TextView
        val symbol: TextView

        init {
            name = itemView.findViewById(R.id.text_name)
            symbol = itemView.findViewById(R.id.text_symbol)
        }

        fun bindData(myCurrency: MyCurrency?) {
            name.text = myCurrency?.name
            symbol.text = myCurrency?.symbol
        }
    }
}