package com.anonymous.berlinclock.model.mapper

import com.anonymous.berlinclock.domain.BerlinClock
import com.anonymous.berlinclock.domain.Lamps
import com.anonymous.berlinclock.model.BerlinClockUIModel
import com.anonymous.berlinclock.model.LampState
import com.anonymous.berlinclock.model.LampState.*
import com.anonymous.berlinclock.utils.Constants.HOURS_AND_MINUTES_LAMP_COUNT
import com.anonymous.berlinclock.utils.Constants.THIRD_LAMP
import com.anonymous.berlinclock.utils.Constants.TOP_MINUTES_COUNT

class BerlinClockUIMapper {

    private lateinit var enabledState: LampState
    private lateinit var disabledState: LampState

    fun map(clock: BerlinClock): BerlinClockUIModel {
        val secondsLampState = if (clock.isSecondsLampOn) YELLOW_ENABLED else YELLOW_DISABLED
        return BerlinClockUIModel(
            secondsLampState = secondsLampState,
            topHourLampStates = clock.topHourLamps.toLampState(),
            bottomHourLampStates = clock.bottomHourLamps.toLampState(),
            topMinuteLampStates = clock.topMinuteLamps.toTopMinutesLampState(),
            bottomMinuteLampStates = clock.bottomMinuteLamps.toLampState(),
            time = clock.time
        )
    }

    private fun Lamps.toLampState(): MutableList<LampState> {
        enabledState = getEnabledStateColor()
        disabledState = getDisabledStateColor()

        val lampStates = MutableList(HOURS_AND_MINUTES_LAMP_COUNT) { disabledState }
        for (index in 0 until HOURS_AND_MINUTES_LAMP_COUNT) {
            lampStates[index] =
                if (index < this.count) enabledState else disabledState
        }
        return lampStates
    }

    private fun Lamps.toTopMinutesLampState(): MutableList<LampState> {
        enabledState = getEnabledStateColor()
        disabledState = getDisabledStateColor()

        val topMinutesLampState = MutableList(TOP_MINUTES_COUNT) { disabledState }
        for (index in 1..TOP_MINUTES_COUNT) {
            topMinutesLampState[index - 1] = if (index <= this.count) {
                if (index.isMultiplesOf3()) RED_ENABLED else enabledState
            } else {
                if (index.isMultiplesOf3()) RED_DISABLED else disabledState
            }
        }
        return topMinutesLampState
    }

    private fun Lamps.getDisabledStateColor() = when (this) {
        is Lamps.BottomHours -> RED_DISABLED
        is Lamps.BottomMinutes -> YELLOW_DISABLED
        is Lamps.TopHours -> RED_DISABLED
        is Lamps.TopMinutes -> YELLOW_DISABLED
    }

    private fun Lamps.getEnabledStateColor() = when (this) {
        is Lamps.BottomHours -> RED_ENABLED
        is Lamps.BottomMinutes -> YELLOW_ENABLED
        is Lamps.TopHours -> RED_ENABLED
        is Lamps.TopMinutes -> YELLOW_ENABLED
    }

    private fun Int.isMultiplesOf3() = this % THIRD_LAMP == 0

}