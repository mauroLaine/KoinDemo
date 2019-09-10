package com.laine.mauro.koindemo

import com.google.gson.Gson
import com.laine.mauro.koindemo.data.DataRepository
import com.laine.mauro.koindemo.data.LocalRepositoryImpl
import org.koin.dsl.module


val applicationModule = module {
    single { Gson() }
    factory { CurrenciesAdapter() }
    factory<DataRepository> { LocalRepositoryImpl(get()) }
}
