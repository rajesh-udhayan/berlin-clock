package com.anonymous.berlinclock

import android.app.Application
import com.anonymous.berlinclock.di.appModule
import org.koin.core.context.startKoin

class BerlinClockApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule)
        }
    }
}