package com.anonymous.berlinclock.di

import com.anonymous.berlinclock.domain.parser.BerlinClockParser
import com.anonymous.berlinclock.model.mapper.BerlinClockUIMapper
import com.anonymous.berlinclock.ui.BerlinClockViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { BerlinClockParser() }
    single { BerlinClockUIMapper() }
    viewModel { BerlinClockViewModel(get(), get()) }
}