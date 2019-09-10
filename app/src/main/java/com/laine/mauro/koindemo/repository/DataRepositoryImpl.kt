package com.laine.mauro.koindemo.repository

import com.google.gson.Gson
import com.laine.mauro.koindemo.model.MyCurrency

class DataRepositoryImpl(private val gson: Gson) {

    fun getCurrencies(jsonString: String): List<MyCurrency> {
        return gson.fromJson(jsonString, Array<MyCurrency>::class.java).toList()
    }
}