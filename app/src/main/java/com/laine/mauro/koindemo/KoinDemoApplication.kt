package com.laine.mauro.koindemo

import android.app.Application
import org.koin.core.context.startKoin

class KoinDemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(applicationModule))
        }
    }
}