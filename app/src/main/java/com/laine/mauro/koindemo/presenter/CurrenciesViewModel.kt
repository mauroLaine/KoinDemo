package com.laine.mauro.koindemo.presenter

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.laine.mauro.koindemo.data.DataRepositoryFactory
import com.laine.mauro.koindemo.model.MyCurrency

class CurrenciesViewModel constructor(private val dataRepositoryFactory: DataRepositoryFactory) : ViewModel() {

    val currencyLiveData = MutableLiveData<List<MyCurrency>>()

    fun observeCurrencies(): LiveData<List<MyCurrency>> {
        return currencyLiveData
    }

    fun retrieveCurrencies(jsonString: String) {
        val data = dataRepositoryFactory.retrieveLocalSource().getCurrencies(jsonString)
        currencyLiveData.postValue(data)
    }
}