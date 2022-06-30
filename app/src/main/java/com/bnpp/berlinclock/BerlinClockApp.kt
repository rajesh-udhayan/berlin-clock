package com.bnpp.berlinclock

import android.app.Application
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bnpp.berlinclock.viewmodel.BerlinClockViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class BerlinClockApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(appModule, viewModelModule))
        }
    }
}

val appModule = module {
    single { BerlinClock() }
}
val viewModelModule = module {
    viewModel { BerlinClockViewModel(get()) }
}