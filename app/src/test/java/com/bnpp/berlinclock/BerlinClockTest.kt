package com.bnpp.berlinclock

import com.bnpp.berlinclock.LampColor.*
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class BerlinClockTest {

    lateinit var berlinClock: BerlinClock

    @Before
    fun setUp(){
        berlinClock = BerlinClock()
    }
    @Test
    fun `should return yellow color when second is 0`(){
        val lampStatus = berlinClock.getSeconds(0)

        assertThat(lampStatus).isEqualTo(YELLOW)
    }

    @Test
    fun `should return off when second is 1`(){
        val lampStatus = berlinClock.getSeconds(1)

        assertThat(lampStatus).isEqualTo(OFF)
    }

    @Test
    fun `should return yellow color for 2 seconds`(){
        val lampStatus = berlinClock.getSeconds(2)

        assertThat(lampStatus).isEqualTo(YELLOW)
    }

    @Test
    fun `should return off color for 3 seconds`(){
        val lampStatus = berlinClock.getSeconds(3)

        assertThat(lampStatus).isEqualTo(OFF)
    }

    @Test
    fun `should return yellow color for 14 seconds`(){
        val lampStatus = berlinClock.getSeconds(14)

        assertThat(lampStatus).isEqualTo(YELLOW)
    }


    @Test
    fun `should return off for 21 seconds`(){
        val lampStatus = berlinClock.getSeconds(21)

        assertThat(lampStatus).isEqualTo(OFF)
    }
}