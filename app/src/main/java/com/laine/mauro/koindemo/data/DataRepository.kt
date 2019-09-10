package com.laine.mauro.koindemo.data

import com.laine.mauro.koindemo.model.MyCurrency

interface DataRepository {
    fun getCurrencies(jsonString: String): List<MyCurrency>
}