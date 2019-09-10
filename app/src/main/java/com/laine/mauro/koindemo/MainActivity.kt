package com.laine.mauro.koindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        currencies_rv.layoutManager = LinearLayoutManager(this)
        currencies_rv.adapter = CurrenciesAdapter()
        currencies_rv.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

    }
}
