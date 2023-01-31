package com.anonymous.berlinclock.domain

data class BerlinClock(
    val isSecondsLampOn:Boolean,
    val topHourLamps: Lamps,
    val bottomHourLamps: Lamps,
    val topMinuteLamps: Lamps,
    val bottomMinuteLamps: Lamps,
    val time: String
)

sealed interface Lamps {
    val count: Int

    data class TopHours(override val count: Int) : Lamps
    data class BottomHours(override val count: Int) : Lamps
    data class TopMinutes(override val count: Int) : Lamps
    data class BottomMinutes(override val count: Int) : Lamps
}