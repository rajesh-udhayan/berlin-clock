package com.anonymous.berlinclock.domain.parser

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import java.time.LocalDateTime

class BerlinClockParserTest {

    private val parser = BerlinClockParser()

    @Test
    fun `should return false for seconds lamp-on when seconds are odd`(){
        val time = LocalDateTime.parse("2022-01-01T00:00:01")

        val clock = parser.parse(time)

        assertThat(clock.isSecondsLampOn).isFalse()
    }

    @Test
    fun `should return true for seconds lamp-on when seconds are even`(){
        val time = LocalDateTime.parse("2022-01-01T00:00:00")

        val clock = parser.parse(time)

        assertThat(clock.isSecondsLampOn).isTrue()
    }

    @Test
    fun `should return 0 for top hour lamps count when hours is less than 5`(){
        val time = LocalDateTime.parse("2022-01-01T04:00:00")

        val clock = parser.parse(time)

        assertThat(clock.topHourLamps.count).isEqualTo(0)
    }

    @Test
    fun `should return 1 for top hour lamps count when hours is less than 10`(){
        val time = LocalDateTime.parse("2022-01-01T08:00:00")

        val clock = parser.parse(time)

        assertThat(clock.topHourLamps.count).isEqualTo(1)
    }

    @Test
    fun `should return 2 for top hour lamps count when hours is less than 15`(){
        val time = LocalDateTime.parse("2022-01-01T12:00:00")

        val clock = parser.parse(time)

        assertThat(clock.topHourLamps.count).isEqualTo(2)
    }

    @Test
    fun `should return 3 for top hour lamps count when hours is less than 20`(){
        val time = LocalDateTime.parse("2022-01-01T19:00:00")

        val clock = parser.parse(time)

        assertThat(clock.topHourLamps.count).isEqualTo(3)
    }

    @Test
    fun `should return 4 for top hour lamps count when hours is greater than or equal to 20`(){
        val time = LocalDateTime.parse("2022-01-01T22:00:00")

        val clock = parser.parse(time)

        assertThat(clock.topHourLamps.count).isEqualTo(4)
    }

    @Test
    fun `should return 0 for bottom hour lamps count when hours is steps of 5 from 0`(){
        val time = LocalDateTime.parse("2022-01-01T15:00:00")

        val clock = parser.parse(time)

        assertThat(clock.bottomHourLamps.count).isEqualTo(0)
    }

    @Test
    fun `should return 1 for bottom hour lamps count when hours is steps of 5 from 1`(){
        val time = LocalDateTime.parse("2022-01-01T06:00:00")

        val clock = parser.parse(time)

        assertThat(clock.bottomHourLamps.count).isEqualTo(1)
    }

    @Test
    fun `should return 2 for bottom hour lamps count when hours is steps of 5 from 2`(){
        val time = LocalDateTime.parse("2022-01-01T22:00:00")

        val clock = parser.parse(time)

        assertThat(clock.bottomHourLamps.count).isEqualTo(2)
    }

    @Test
    fun `should return 3 for bottom hour lamps count when hours is steps of 5 from 3`(){
        val time = LocalDateTime.parse("2022-01-01T13:00:00")

        val clock = parser.parse(time)

        assertThat(clock.bottomHourLamps.count).isEqualTo(3)
    }

    @Test
    fun `should return 4 for bottom hour lamps count when hours is steps of 5 from 4`(){
        val time = LocalDateTime.parse("2022-01-01T14:00:00")

        val clock = parser.parse(time)

        assertThat(clock.bottomHourLamps.count).isEqualTo(4)
    }

    @Test
    fun `should return 0 for top minute lamps count when minutes is less than 5`(){
        val time = LocalDateTime.parse("2022-01-01T02:04:00")

        val clock = parser.parse(time)

        assertThat(clock.topMinuteLamps.count).isEqualTo(0)
    }

    @Test
    fun `should return 1 for top minute lamps count when minutes is less than 10`(){
        val time = LocalDateTime.parse("2022-01-01T02:09:00")

        val clock = parser.parse(time)

        assertThat(clock.topMinuteLamps.count).isEqualTo(1)
    }

    @Test
    fun `should return 2 for top minute lamps count when minutes is less than 15`(){
        val time = LocalDateTime.parse("2022-01-01T02:12:00")

        val clock = parser.parse(time)

        assertThat(clock.topMinuteLamps.count).isEqualTo(2)
    }

    @Test
    fun `should return 3 for top minute lamps count when minutes is less than 20`(){
        val time = LocalDateTime.parse("2022-01-01T02:15:00")

        val clock = parser.parse(time)

        assertThat(clock.topMinuteLamps.count).isEqualTo(3)
    }

    @Test
    fun `should return 4 for top minute lamps count when minutes is less than 25`(){
        val time = LocalDateTime.parse("2022-01-01T02:22:00")

        val clock = parser.parse(time)

        assertThat(clock.topMinuteLamps.count).isEqualTo(4)
    }

    @Test
    fun `should return 5 for top minute lamps count when minutes is less than 30`(){
        val time = LocalDateTime.parse("2022-01-01T02:29:00")

        val clock = parser.parse(time)

        assertThat(clock.topMinuteLamps.count).isEqualTo(5)
    }

    @Test
    fun `should return 6 for top minute lamps count when minutes is less than 35`(){
        val time = LocalDateTime.parse("2022-01-01T02:34:00")

        val clock = parser.parse(time)

        assertThat(clock.topMinuteLamps.count).isEqualTo(6)
    }

    @Test
    fun `should return 7 for top minute lamps count when minutes is less than 40`(){
        val time = LocalDateTime.parse("2022-01-01T02:39:00")

        val clock = parser.parse(time)

        assertThat(clock.topMinuteLamps.count).isEqualTo(7)
    }

    @Test
    fun `should return 8 for top minute lamps count when minutes is less than 45`(){
        val time = LocalDateTime.parse("2022-01-01T02:43:00")

        val clock = parser.parse(time)

        assertThat(clock.topMinuteLamps.count).isEqualTo(8)
    }

    @Test
    fun `should return 9 for top minute lamps count when minutes is less than 50`(){
        val time = LocalDateTime.parse("2022-01-01T02:49:00")

        val clock = parser.parse(time)

        assertThat(clock.topMinuteLamps.count).isEqualTo(9)
    }

    @Test
    fun `should return 10 for top minute lamps count when minutes is less than 55`(){
        val time = LocalDateTime.parse("2022-01-01T02:54:00")

        val clock = parser.parse(time)

        assertThat(clock.topMinuteLamps.count).isEqualTo(10)
    }

    @Test
    fun `should return 11 for top minute lamps count when minutes is greater than or equal to 55`(){
        val time = LocalDateTime.parse("2022-01-01T02:59:00")

        val clock = parser.parse(time)

        assertThat(clock.topMinuteLamps.count).isEqualTo(11)
    }

    @Test
    fun `should return 0 for bottom minute lamps count when minutes is steps of 5 from 0`(){
        val time = LocalDateTime.parse("2022-01-01T02:50:00")

        val clock = parser.parse(time)

        assertThat(clock.bottomMinuteLamps.count).isEqualTo(0)
    }

    @Test
    fun `should return 1 for bottom minute lamps count when minutes is steps of 5 from 1`(){
        val time = LocalDateTime.parse("2022-01-01T02:26:10")

        val clock = parser.parse(time)

        assertThat(clock.bottomMinuteLamps.count).isEqualTo(1)
    }

    @Test
    fun `should return 2 for bottom minute lamps count when minutes is steps of 5 from 2`(){
        val time = LocalDateTime.parse("2022-01-01T02:47:10")

        val clock = parser.parse(time)

        assertThat(clock.bottomMinuteLamps.count).isEqualTo(2)
    }

    @Test
    fun `should return 3 for bottom minute lamps count when minutes is steps of 5 from 3`(){
        val time = LocalDateTime.parse("2022-01-01T02:33:10")

        val clock = parser.parse(time)

        assertThat(clock.bottomMinuteLamps.count).isEqualTo(3)
    }

    @Test
    fun `should return 4 for bottom minute lamps count when minutes is steps of 5 from 4`(){
        val time = LocalDateTime.parse("2022-01-01T02:59:10")

        val clock = parser.parse(time)

        assertThat(clock.bottomMinuteLamps.count).isEqualTo(4)
    }

    @Test
    fun `should return formatted string for given time`() {
        val timeString = "2022-01-01T08:59:01"
        val time = LocalDateTime.parse(timeString)
        val formattedTime = "08:59:01"

        val clock = parser.parse(time)

        assertThat(clock.time).isEqualTo(formattedTime)
    }
}