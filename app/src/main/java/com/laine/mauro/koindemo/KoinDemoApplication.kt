package com.laine.mauro.koindemo

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KoinDemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@KoinDemoApplication)
            androidFileProperties()
            androidLogger()
            modules(listOf(applicationModule))
        }
    }
}