package com.laine.mauro.koindemo

import com.google.gson.Gson
import com.laine.mauro.koindemo.data.DataRepository
import com.laine.mauro.koindemo.data.DataRepositoryImpl
import org.koin.dsl.module


val applicationModule = module {
    single { Gson() }
    factory { CurrenciesAdapter() }
    factory<DataRepository> { DataRepositoryImpl(get()) }
}
