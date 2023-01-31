package com.anonymous.berlinclock.model

import com.anonymous.berlinclock.utils.Constants

data class BerlinClockUIModel(
    val secondsLampState: LampState,
    val topHourLampStates: List<LampState>,
    val bottomHourLampStates: List<LampState>,
    val topMinuteLampStates: List<LampState>,
    val bottomMinuteLampStates: List<LampState>,
    val time: String
){
    companion object {
        fun initialState(): BerlinClockUIModel {
            return BerlinClockUIModel(
                secondsLampState = LampState.YELLOW_DISABLED,
                topHourLampStates = listOf(LampState.RED_DISABLED),
                bottomHourLampStates = listOf(LampState.RED_DISABLED),
                topMinuteLampStates = listOf(LampState.YELLOW_DISABLED),
                bottomMinuteLampStates = listOf(LampState.YELLOW_DISABLED),
                time = Constants.DEFAULT_TIME
            )
        }
    }
}
