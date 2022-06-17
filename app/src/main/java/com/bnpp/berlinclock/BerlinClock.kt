package com.bnpp.berlinclock

import com.bnpp.berlinclock.LampColor.*

class BerlinClock {

    fun getSeconds(seconds: Int): LampColor =
        if (seconds % 2 == 0) YELLOW
        else OFF

}
