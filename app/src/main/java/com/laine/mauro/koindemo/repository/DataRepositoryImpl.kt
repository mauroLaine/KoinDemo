package com.laine.mauro.koindemo.repository

import com.google.gson.Gson
import com.laine.mauro.koindemo.model.Currency

class DataRepositoryImpl(private val gson: Gson) {

    fun getCurrencies(jsonString: String): List<Currency> {
        return gson.fromJson(jsonString, Array<Currency>::class.java).toList()
    }
}