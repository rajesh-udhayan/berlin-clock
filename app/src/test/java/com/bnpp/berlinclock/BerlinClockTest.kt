package com.bnpp.berlinclock

import com.bnpp.berlinclock.LampColor.*
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class BerlinClockTest {

    @Test
    fun `should return yellow color when second is 0`(){
        val berlinClock = BerlinClock()
        val lampStatus = berlinClock.getSeconds(0)

        assertThat(lampStatus).isEqualTo(YELLOW)
    }

    @Test
    fun `should return off when second is 1`(){
        val berlinClock = BerlinClock()
        val lampStatus = berlinClock.getSeconds(1)

        assertThat(lampStatus).isEqualTo(OFF)
    }
}