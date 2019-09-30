package com.laine.mauro.koindemo

import com.google.gson.Gson
import com.laine.mauro.koindemo.data.DataRepository
import com.laine.mauro.koindemo.data.DataRepositoryFactory
import com.laine.mauro.koindemo.data.LocalRepositoryImpl
import com.laine.mauro.koindemo.data.RemoteRepositoryImpl
import com.laine.mauro.koindemo.presenter.CurrenciesAdapter
import com.laine.mauro.koindemo.presenter.CurrenciesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module


val applicationModule = module {
    single { Gson() }
    single { UrlHelper() }
    factory { CurrenciesAdapter() }
    factory<DataRepository>(named("local")) { LocalRepositoryImpl(get()) }
    factory<DataRepository>(named("remote")) { RemoteRepositoryImpl() }
    factory { DataRepositoryFactory(get(named("local")), get(named("remote"))) }
    viewModel { CurrenciesViewModel(get()) }
}
