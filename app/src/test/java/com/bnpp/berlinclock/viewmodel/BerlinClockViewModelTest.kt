package com.bnpp.berlinclock.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bnpp.berlinclock.BerlinClock
import com.bnpp.berlinclock.LampColor
import com.bnpp.berlinclock.LampColor.*
import com.bnpp.berlinclock.model.BerlinClockData
import com.bnpp.berlinclock.model.Hours
import com.bnpp.berlinclock.model.Minutes
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

    @Test
    fun return_value_from_livedata_equals_expected_berlin_clock_data() {
        val time = "12:10:01"

        viewModel.updateTime(time)
        val value = viewModel.berlinClockTime.getOrAwaitValue()

        assertThat(value).isEqualTo(expectedBerlinClockData())
    }

    private fun expectedBerlinClockData(): BerlinClockData {
        val hoursOnTop = listOf(RED, RED, OFF, OFF)
        val hoursOnBottom = listOf(RED, RED, OFF, OFF)
        val minutesOnTop = listOf(YELLOW, YELLOW, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF)
        val minutesOnBottom = listOf(OFF, OFF, OFF, OFF)
        return BerlinClockData(
            hoursLamp = Hours(topLamps = hoursOnTop, bottomLamps = hoursOnBottom),
            minutesLamp = Minutes(topLamps = minutesOnTop, bottomLamps = minutesOnBottom),
            secondsLamp = OFF
        )
    }
}