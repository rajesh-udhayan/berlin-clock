package com.bnpp.berlinclock.model

import com.bnpp.berlinclock.LampColor


data class BerlinClockData(
    val secondsLamp: LampColor,
    val minutesLamp: Minutes,
    val hoursLamp: Hours
) {
    companion object {
        fun default() = BerlinClockData(LampColor.OFF, Minutes(), Hours())
    }
}
