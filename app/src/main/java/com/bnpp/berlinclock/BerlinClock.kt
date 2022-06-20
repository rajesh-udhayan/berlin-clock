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
