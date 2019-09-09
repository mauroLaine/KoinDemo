package com.laine.mauro.koindemo

import com.google.gson.Gson
import org.koin.dsl.module


val applicationModule = module {
    single { Gson() }
}
