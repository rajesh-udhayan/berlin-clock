package com.anonymous.berlinclock.domain.parser

import com.anonymous.berlinclock.domain.BerlinClock
import com.anonymous.berlinclock.domain.Lamps.*
import com.anonymous.berlinclock.utils.Constants
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class BerlinClockParser {

    fun parse(time: LocalDateTime): BerlinClock {
        val seconds = time.second
        val hours = time.hour
        val minutes = time.minute
        return BerlinClock(
            isSecondsLampOn = seconds.isEven(),
            topHourLamps = TopHours(hours / Constants.DIVISOR_FOR_LAMP_COUNT),
            bottomHourLamps = BottomHours(hours % Constants.MOD_FOR_LAMP_COUNT),
            topMinuteLamps = TopMinutes(minutes / Constants.DIVISOR_FOR_LAMP_COUNT),
            bottomMinuteLamps = BottomMinutes(minutes % Constants.MOD_FOR_LAMP_COUNT),
            time = time.format(DateTimeFormatter.ofPattern(Constants.TIME_FORMAT))
        )
    }

    private fun Int.isEven() = this % 2 == 0
}