package com.laine.mauro.koindemo.data

import com.google.gson.Gson
import com.laine.mauro.koindemo.model.MyCurrency

class LocalRepositoryImpl(private val gson: Gson) : DataRepository {

    override fun getCurrencies(jsonString: String): List<MyCurrency> {
        return gson.fromJson(jsonString, Array<MyCurrency>::class.java).toList()
    }
}