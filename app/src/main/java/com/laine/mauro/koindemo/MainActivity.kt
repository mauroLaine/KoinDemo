package com.laine.mauro.koindemo

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.laine.mauro.koindemo.presenter.CurrenciesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val currenciesAdapter: CurrenciesAdapter by inject()
    private val currenciesViewModel: CurrenciesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpCurrenciesRecyclerView()

        currenciesViewModel.observeCurrencies().observe(this, Observer {
            currenciesAdapter.currencies = it
        })

        val currenciesJson = resources.openRawResource(R.raw.currencies).bufferedReader().use { it.readText() }
        currenciesViewModel.retrieveCurrencies(currenciesJson)
    }

    private fun setUpCurrenciesRecyclerView() {
        currencies_rv.layoutManager = LinearLayoutManager(this)
        currencies_rv.adapter = currenciesAdapter
        currencies_rv.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }
}
