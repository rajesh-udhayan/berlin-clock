package com.bnpp.berlinclock

import com.bnpp.berlinclock.LampColor.*
import com.bnpp.berlinclock.model.Hours
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

    @Test
    fun `should return first top and bottom lamp as yellow and others as off when minutes is 6`(){
        val lampStatus = berlinClock.getMinutes(6)

        val topLamps = listOf(YELLOW, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF)
        val bottomLamps = listOf(YELLOW, OFF, OFF, OFF)
        val expectedLampColor = Minutes(topLamps, bottomLamps)

        assertThat(lampStatus).isEqualTo(expectedLampColor)
    }

    @Test
    fun `should return first two top and first bottom lamp as yellow and others as off when minutes is 11`(){
        val lampStatus = berlinClock.getMinutes(11)

        val topLamps = listOf(YELLOW, YELLOW, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF)
        val bottomLamps = listOf(YELLOW, OFF, OFF, OFF)
        val expectedLampColor = Minutes(topLamps, bottomLamps)

        assertThat(lampStatus).isEqualTo(expectedLampColor)
    }

    @Test
    fun `should return first three top lamps as on when minutes is 15`(){
        val lampStatus = berlinClock.getMinutes(15)

        val topLamps = listOf(YELLOW, YELLOW, RED, OFF, OFF, OFF, OFF, OFF, OFF, OFF, OFF)
        val bottomLamps = listOf(OFF, OFF, OFF, OFF)
        val expectedLampColor = Minutes(topLamps, bottomLamps)

        assertThat(lampStatus).isEqualTo(expectedLampColor)
    }

    @Test
    fun `should return first six top lamps as on when minutes is 30`() {
        val result = berlinClock.getMinutes(30)

        val minutesOnTop = listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, OFF, OFF, OFF, OFF, OFF)
        val minutesOnBottom = listOf(OFF, OFF, OFF, OFF)
        val expectedResult = Minutes(topLamps = minutesOnTop, bottomLamps = minutesOnBottom)
        assertThat(expectedResult).isEqualTo(result)
    }

    @Test
    fun `should return first nine top lamps as on when minutes is 45`() {
        val result = berlinClock.getMinutes(45)

        val minutesOnTop = listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, OFF, OFF)
        val minutesOnBottom = listOf(OFF, OFF, OFF, OFF)
        val expectedResult = Minutes(topLamps = minutesOnTop, bottomLamps = minutesOnBottom)
        assertThat(expectedResult).isEqualTo(result)
    }

    @Test
    fun `should return all lamps as on when minutes is 59`() {
        val result = berlinClock.getMinutes(59)

        val minutesOnTop = listOf(YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW, RED, YELLOW, YELLOW)
        val minutesOnBottom = listOf(YELLOW, YELLOW, YELLOW, YELLOW)
        val expectedResult = Minutes(topLamps = minutesOnTop, bottomLamps = minutesOnBottom)
        assertThat(expectedResult).isEqualTo(result)
    }

    @Test
    fun `should return all bottom lamp as off when hour is 0`(){
        val result = berlinClock.getHours(0)

        val hoursOnBottom = listOf(OFF,OFF,OFF,OFF)
        val expectedResult = Hours(bottomLamps = hoursOnBottom)

        assertThat(expectedResult).isEqualTo(result)
    }

    @Test
    fun `should return first bottom lamp as red and others as off when hour is 1`(){
        val result = berlinClock.getHours(1)

        val hoursOnBottom = listOf(RED,OFF,OFF,OFF)
        val expectedResult = Hours(bottomLamps = hoursOnBottom)

        assertThat(expectedResult).isEqualTo(result)
    }

    @Test
    fun `should return first two bottom lamp as red and others as off when hour is 2`(){
        val result = berlinClock.getHours(2)

        val hoursOnBottom = listOf(RED,RED,OFF,OFF)
        val expectedResult = Hours(bottomLamps = hoursOnBottom)

        assertThat(expectedResult).isEqualTo(result)
    }

    @Test
    fun `should return first three bottom lamp as red and others as off when hour is 3`(){
        val result = berlinClock.getHours(3)

        val hoursOnBottom = listOf(RED,RED,RED,OFF)
        val expectedResult = Hours(bottomLamps = hoursOnBottom)

        assertThat(expectedResult).isEqualTo(result)
    }

    @Test
    fun `should return all bottom lamp as red when hour is 4`(){
        val result = berlinClock.getHours(4)

        val hoursOnBottom = listOf(RED,RED,RED,RED)
        val expectedResult = Hours(bottomLamps = hoursOnBottom)

        assertThat(expectedResult).isEqualTo(result)
    }

    @Test
    fun `should return first top lamp as red and others as off when hour is 5`(){
        val result = berlinClock.getHours(5)

        val hoursOnTop = listOf(RED, OFF, OFF, OFF)
        val hoursOnBottom = listOf(OFF, OFF, OFF, OFF)
        val expectedResult = Hours(topLamps =  hoursOnTop, bottomLamps = hoursOnBottom)

        assertThat(expectedResult).isEqualTo(result)
    }

    @Test
    fun `should return first top and bottom lamp as red and others as off when hour is 6`(){
        val result = berlinClock.getHours(6)

        val hoursOnTop = listOf(RED, OFF, OFF, OFF)
        val hoursOnBottom = listOf(RED, OFF, OFF, OFF)
        val expectedResult = Hours(topLamps =  hoursOnTop, bottomLamps = hoursOnBottom)

        assertThat(expectedResult).isEqualTo(result)
    }

}