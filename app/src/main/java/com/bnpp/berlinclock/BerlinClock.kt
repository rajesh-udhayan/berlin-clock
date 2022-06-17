package com.bnpp.berlinclock

import com.bnpp.berlinclock.LampColor.*
import com.bnpp.berlinclock.model.Minutes

class BerlinClock {

    fun getSeconds(seconds: Int): LampColor =
        if (seconds % 2 == 0) YELLOW
        else OFF

    fun getMinutes(minutes: Int): Minutes {
        if (minutes == 1){
            return Minutes(bottomLamps = listOf(YELLOW,OFF,OFF,OFF))
        }
        return Minutes()
    }

}
