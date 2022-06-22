package com.bnpp.berlinclock

import com.bnpp.berlinclock.LampColor.*
import com.bnpp.berlinclock.model.Hours
import com.bnpp.berlinclock.model.Minutes

class BerlinClock {

    fun getSeconds(seconds: Int): LampColor =
        if (seconds % 2 == 0) YELLOW
        else OFF

    fun getMinutes(minutes: Int): Minutes = when{
            minutes.lessThanFive() -> getLampsForLessThanFiveMinutes(minutes)
            minutes.greaterThanOrEqualsFive() -> getLampsForMoreThanFiveMinutes(minutes)
            else -> Minutes()
        }

    private fun getLampsForLessThanFiveMinutes(minutes: Int) =
        Minutes(
            bottomLamps = getBottomLampsColor(minutes)
        )

    private fun getLampsForMoreThanFiveMinutes(minutes: Int): Minutes {
        val topLampsCount = minutes/5
        val bottomLampsCount = minutes%5
        val topMinutes = getTopLampsColor(topLampsCount)
        val bottomMinutes = getBottomLampsColor(bottomLampsCount)
        return Minutes(topMinutes,bottomMinutes)
    }

    private fun getBottomLampsColor(minutes: Int): List<LampColor> {
        val lampColors: MutableList<LampColor> = Minutes.defaultBottom()
        (1..minutes).forEach{ i ->
            lampColors[i-1] = YELLOW
        }
        return lampColors
    }

    private fun getTopLampsColor(lampsCount: Int): List<LampColor> {
        val lampColors: MutableList<LampColor> = Minutes.defaultTop()
        (1..lampsCount).forEach { i ->
            if (i.multiplesOfThree()) {
                lampColors[i - 1] = RED
            } else {
                lampColors[i - 1] = YELLOW
            }
        }
        return lampColors
    }

    fun getHours(hours: Int): Hours {
        return when (hours) {
            1 -> Hours(bottomLamps = listOf(RED, OFF, OFF, OFF))
            2 -> Hours(bottomLamps = listOf(RED, RED, OFF, OFF))
            3 -> Hours(bottomLamps = listOf(RED, RED, RED, OFF))
            4 -> Hours(bottomLamps = listOf(RED, RED, RED, RED))
            else -> Hours()
        }
    }

    private fun Int.greaterThanOrEqualsFive() = this >= 5
    private fun Int.lessThanFive() = this < 5
    private fun Int.multiplesOfThree() = this % 3 == 0


}
