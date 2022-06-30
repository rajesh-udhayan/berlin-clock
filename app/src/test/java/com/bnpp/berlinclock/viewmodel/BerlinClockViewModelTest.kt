package com.bnpp.berlinclock.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bnpp.berlinclock.BerlinClock
import com.bnpp.berlinclock.model.BerlinClockData
import com.bnpp.berlinclock.utils.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class BerlinClockViewModelTest {

    private val berlinClock = BerlinClock()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: BerlinClockViewModel

    @Before
    fun setUp(){
        viewModel = BerlinClockViewModel(berlinClock)
    }

    @Test
    fun `should initialize berlin clock when init function called`(){
        viewModel.initBerlinClock()

        val value = viewModel.berlinClockTime.getOrAwaitValue()
        val expectedResult = BerlinClockData.default()

        assertThat(value).isEqualTo(expectedResult)
    }
}