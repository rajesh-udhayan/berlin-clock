package com.anonymous.berlinclock.ui

import com.anonymous.berlinclock.domain.BerlinClock
import com.anonymous.berlinclock.domain.Lamps
import com.anonymous.berlinclock.domain.parser.BerlinClockParser
import com.anonymous.berlinclock.model.BerlinClockUIModel
import com.anonymous.berlinclock.model.LampState
import com.anonymous.berlinclock.model.mapper.BerlinClockUIMapper
import com.anonymous.berlinclock.utils.MainCoroutineRule
import com.google.common.truth.Truth.assertThat
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test
import java.time.LocalDateTime

@ExperimentalCoroutinesApi
class BerlinClockViewModelTest {

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Test
    fun `should return clock state for given time`() {
        val parser: BerlinClockParser = mockk()
        val mapper: BerlinClockUIMapper = mockk()
        val viewModel = BerlinClockViewModel(parser, mapper)
        val dateTime = LocalDateTime.parse("2022-01-01T07:30:26")
        val berlinClock = getBerlinClock()
        val berlinClockState = getBerlinClockUIModel()

        every { parser.parse(dateTime) } returns berlinClock
        every { mapper.map(berlinClock) } returns berlinClockState
        viewModel.updateTime(dateTime)

        val clockState = viewModel.berlinClockState.value

        assertThat(clockState).isEqualTo(berlinClockState)
    }

    private fun getBerlinClock(): BerlinClock {
        return BerlinClock(
            isSecondsLampOn = true,
            topHourLamps = Lamps.TopHours(1),
            bottomHourLamps = Lamps.BottomHours(2),
            topMinuteLamps = Lamps.TopMinutes(6),
            bottomMinuteLamps = Lamps.BottomMinutes(0),
            time = "07:30:26"
        )
    }

    private fun getBerlinClockUIModel(): BerlinClockUIModel {
        return BerlinClockUIModel(
            secondsLampState = LampState.YELLOW_ENABLED,
            topHourLampStates = listOf(
                LampState.RED_ENABLED,
                LampState.RED_DISABLED,
                LampState.RED_DISABLED,
                LampState.RED_DISABLED
            ),
            bottomHourLampStates = listOf(
                LampState.RED_ENABLED,
                LampState.RED_ENABLED,
                LampState.RED_ENABLED,
                LampState.RED_DISABLED,
            ),
            topMinuteLampStates = listOf(
                LampState.YELLOW_ENABLED,
                LampState.YELLOW_ENABLED,
                LampState.RED_ENABLED,
                LampState.YELLOW_ENABLED,
                LampState.YELLOW_ENABLED,
                LampState.RED_ENABLED,
                LampState.YELLOW_DISABLED,
                LampState.YELLOW_DISABLED,
                LampState.RED_DISABLED,
                LampState.YELLOW_DISABLED,
                LampState.YELLOW_DISABLED
            ),
            bottomMinuteLampStates = listOf(
                LampState.YELLOW_DISABLED,
                LampState.YELLOW_DISABLED,
                LampState.YELLOW_DISABLED,
                LampState.YELLOW_DISABLED
            ),
            time = "07:30:26"
        )
    }
}