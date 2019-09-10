package com.laine.mauro.koindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.laine.mauro.koindemo.data.DataRepositoryImpl
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val currenciesAdapter: CurrenciesAdapter by inject()
    private val dataRepositoryImpl: DataRepositoryImpl = get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpCurrenciesRecyclerView()

        val currenciesJson = resources.openRawResource(R.raw.currencies).bufferedReader().use { it.readText() }
        val items = dataRepositoryImpl.getCurrencies(currenciesJson)
        currenciesAdapter.currencies = items

    }

    private fun setUpCurrenciesRecyclerView() {
        currencies_rv.layoutManager = LinearLayoutManager(this)
        currencies_rv.adapter = currenciesAdapter
        currencies_rv.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }
}
