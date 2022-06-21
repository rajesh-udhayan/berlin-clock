package com.bnpp.berlinclock

import com.bnpp.berlinclock.LampColor.*
import com.bnpp.berlinclock.model.Minutes

class BerlinClock {

    fun getSeconds(seconds: Int): LampColor =
        if (seconds % 2 == 0) YELLOW
        else OFF

    fun getMinutes(minutes: Int): Minutes {
        return when(minutes){
            in 1..4 -> Minutes(
                bottomLamps = getBottomLampsColor(minutes)
            )
            5 -> {
                val topMinutes = listOf(YELLOW, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF)
                Minutes(topMinutes, bottomLamps = Minutes.defaultBottom())
            }
            6 -> {
                val topMinutes = listOf(YELLOW, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF)
                val bottomMinutes = listOf(YELLOW, OFF, OFF, OFF)
                Minutes(topMinutes, bottomMinutes)
            }
            else -> Minutes()
        }
    }

    private fun getBottomLampsColor(minutes: Int): List<LampColor> {
        val lampColors: MutableList<LampColor> = Minutes.defaultBottom()
        (1..minutes).forEach{ i ->
            lampColors[i-1] = YELLOW
        }
        return lampColors
    }

}
