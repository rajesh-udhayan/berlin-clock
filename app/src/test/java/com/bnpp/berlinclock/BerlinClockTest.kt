package com.bnpp.berlinclock

import com.bnpp.berlinclock.LampColor.*
import com.bnpp.berlinclock.model.Minutes
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

    @Test
    fun `should return off for all lamp when minute is 0`(){
        val lampStatus = berlinClock.getMinutes(0)

        val topLamps = listOf(OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF)
        val bottomLamps = listOf(OFF, OFF, OFF, OFF)
        val expectedLampColor = Minutes(topLamps, bottomLamps)

        assertThat(lampStatus).isEqualTo(expectedLampColor)
    }

    @Test
    fun `should return first bottom lamp as yellow and others as off when minute is 1`(){
        val lampStatus = berlinClock.getMinutes(1)

        val topLamps = listOf(OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF)
        val bottomLamps = listOf(YELLOW, OFF, OFF, OFF)
        val expectedLampColor = Minutes(topLamps, bottomLamps)

        assertThat(lampStatus).isEqualTo(expectedLampColor)
    }

    @Test
    fun `should return first two bottom lamp as yellow and others as off when minute is 2`(){
        val lampStatus = berlinClock.getMinutes(2)

        val topLamps = listOf(OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF)
        val bottomLamps = listOf(YELLOW, YELLOW, OFF, OFF)
        val expectedLampColor = Minutes(topLamps, bottomLamps)

        assertThat(lampStatus).isEqualTo(expectedLampColor)
    }

    @Test
    fun `should return first three bottom lamp as yellow and others as off when minute is 3`(){
        val lampStatus = berlinClock.getMinutes(3)

        val topLamps = listOf(OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF)
        val bottomLamps = listOf(YELLOW, YELLOW, YELLOW, OFF)
        val expectedLampColor = Minutes(topLamps, bottomLamps)

        assertThat(lampStatus).isEqualTo(expectedLampColor)
    }

    @Test
    fun `should return all bottom lamp as yellow and others as off when minute is 4`(){
        val lampStatus = berlinClock.getMinutes(4)

        val topLamps = listOf(OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF)
        val bottomLamps = listOf(YELLOW, YELLOW, YELLOW, YELLOW)
        val expectedLampColor = Minutes(topLamps, bottomLamps)

        assertThat(lampStatus).isEqualTo(expectedLampColor)
    }

    @Test
    fun `should return first top lamp as yellow and others as off when minutes is 5`(){
        val lampStatus = berlinClock.getMinutes(5)

        val topLamps = listOf(YELLOW, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF)
        val bottomLamps = listOf(OFF, OFF, OFF, OFF)
        val expectedLampColor = Minutes(topLamps, bottomLamps)

        assertThat(lampStatus).isEqualTo(expectedLampColor)
    }
}