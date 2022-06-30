package com.bnpp.berlinclock

import android.app.Application
import org.koin.core.context.startKoin
import org.koin.dsl.module

class BerlinClockApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(appModule))
        }
    }
}

val appModule = module {
    single { BerlinClock() }
}