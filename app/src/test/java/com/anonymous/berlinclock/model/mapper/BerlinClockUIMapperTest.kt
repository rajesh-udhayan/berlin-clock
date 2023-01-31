package com.anonymous.berlinclock.model.mapper

import com.anonymous.berlinclock.domain.BerlinClock
import com.anonymous.berlinclock.domain.Lamps
import com.anonymous.berlinclock.model.LampState
import com.anonymous.berlinclock.utils.Constants
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class BerlinClockUIMapperTest {

    private val mapper = BerlinClockUIMapper()
    private val berlinClock = BerlinClock(
        isSecondsLampOn = false,
        topHourLamps = Lamps.TopHours(0),
        bottomHourLamps = Lamps.BottomHours(0),
        topMinuteLamps = Lamps.TopMinutes(0),
        bottomMinuteLamps = Lamps.BottomMinutes(0),
        time = Constants.DEFAULT_TIME
    )

    @Test
    fun `should return disabled yellow color as lamp state for seconds lamp-off`() {
        val clockState = mapper.map(berlinClock)

        assertThat(clockState.secondsLampState).isEqualTo(LampState.YELLOW_DISABLED)
    }

    @Test
    fun `should return enabled yellow color as lamp state for seconds lamp-on`() {
        val clock = berlinClock.copy(isSecondsLampOn = true)

        val clockState = mapper.map(clock)

        assertThat(clockState.secondsLampState).isEqualTo(LampState.YELLOW_ENABLED)
    }

    @Test
    fun `should return disable red color for all top hours lamp state when top hour count is 0`() {
        val clock = berlinClock.copy(topHourLamps = Lamps.TopHours(0))

        val clockState = mapper.map(clock)

        assertThat(clockState.topHourLampStates).isEqualTo(
            listOf(
                LampState.RED_DISABLED, LampState.RED_DISABLED,
                LampState.RED_DISABLED, LampState.RED_DISABLED
            )
        )
    }

    @Test
    fun `should return enabled red color for first top lamp and disabled red color for other top lamps when top hour count is 1`() {
        val clock = berlinClock.copy(topHourLamps = Lamps.TopHours(1))

        val clockState = mapper.map(clock)

        assertThat(clockState.topHourLampStates).isEqualTo(
            listOf(
                LampState.RED_ENABLED, LampState.RED_DISABLED,
                LampState.RED_DISABLED, LampState.RED_DISABLED
            )
        )
    }

    @Test
    fun `should return enabled red color for first two top lamps and disabled red color for other top lamps when top hour count is 2`() {
        val clock = berlinClock.copy(topHourLamps = Lamps.TopHours(2))

        val clockState = mapper.map(clock)

        assertThat(clockState.topHourLampStates).isEqualTo(
            listOf(
                LampState.RED_ENABLED, LampState.RED_ENABLED,
                LampState.RED_DISABLED, LampState.RED_DISABLED
            )
        )
    }

    @Test
    fun `should return enabled red color for first three top lamps and disabled red color for last top lamp when top hour count is 3`() {
        val clock = berlinClock.copy(topHourLamps = Lamps.TopHours(3))

        val clockState = mapper.map(clock)

        assertThat(clockState.topHourLampStates).isEqualTo(
            listOf(
                LampState.RED_ENABLED, LampState.RED_ENABLED,
                LampState.RED_ENABLED, LampState.RED_DISABLED
            )
        )
    }

    @Test
    fun `should return enabled red color for all top lamps when top hour count is 4`() {
        val clock = berlinClock.copy(topHourLamps = Lamps.TopHours(4))

        val clockState = mapper.map(clock)

        assertThat(clockState.topHourLampStates).isEqualTo(
            listOf(
                LampState.RED_ENABLED, LampState.RED_ENABLED,
                LampState.RED_ENABLED, LampState.RED_ENABLED
            )
        )
    }

    @Test
    fun `should return disabled red color for all bottom lamps when bottom hour count is 0`() {
        val clock = berlinClock.copy(bottomHourLamps = Lamps.BottomHours(0))

        val clockState = mapper.map(clock)

        assertThat(clockState.bottomHourLampStates).isEqualTo(
            listOf(
                LampState.RED_DISABLED, LampState.RED_DISABLED,
                LampState.RED_DISABLED, LampState.RED_DISABLED
            )
        )
    }

    @Test
    fun `should return enabled red color for first bottom lamp and disabled red color for other bottom lamps when bottom hour count is 1`() {
        val clock = berlinClock.copy(bottomHourLamps = Lamps.BottomHours(1))

        val clockState = mapper.map(clock)

        assertThat(clockState.bottomHourLampStates).isEqualTo(
            listOf(
                LampState.RED_ENABLED, LampState.RED_DISABLED,
                LampState.RED_DISABLED, LampState.RED_DISABLED
            )
        )
    }

    @Test
    fun `should return enabled red color for first two bottom lamps and disabled red color for other bottom lamps when bottom hour count is 2`() {
        val clock = berlinClock.copy(bottomHourLamps = Lamps.BottomHours(2))

        val clockState = mapper.map(clock)

        assertThat(clockState.bottomHourLampStates).isEqualTo(
            listOf(
                LampState.RED_ENABLED, LampState.RED_ENABLED,
                LampState.RED_DISABLED, LampState.RED_DISABLED
            )
        )
    }

    @Test
    fun `should return enabled red color for first three bottom lamps and disabled red color for last bottom lamp when bottom hour count is 3`() {
        val clock = berlinClock.copy(bottomHourLamps = Lamps.BottomHours(3))

        val clockState = mapper.map(clock)

        assertThat(clockState.bottomHourLampStates).isEqualTo(
            listOf(
                LampState.RED_ENABLED, LampState.RED_ENABLED,
                LampState.RED_ENABLED, LampState.RED_DISABLED
            )
        )
    }

    @Test
    fun `should return enabled red color for all bottom lamps when top hour count is 4`() {
        val clock = berlinClock.copy(bottomHourLamps = Lamps.BottomHours(4))

        val clockState = mapper.map(clock)

        assertThat(clockState.bottomHourLampStates).isEqualTo(
            listOf(
                LampState.RED_ENABLED, LampState.RED_ENABLED,
                LampState.RED_ENABLED, LampState.RED_ENABLED
            )
        )
    }

    @Test
    fun `should return disabled yellow color for all bottom lamps and disabled red color for every third lamps when top minutes count is 0`() {
        val clock = berlinClock.copy(topMinuteLamps = Lamps.TopMinutes(0))

        val clockState = mapper.map(clock)

        assertThat(clockState.topMinuteLampStates).isEqualTo(
            listOf(
                LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED,
                LampState.RED_DISABLED, LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED,
                LampState.RED_DISABLED, LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED,
                LampState.RED_DISABLED, LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED
            )
        )
    }

    @Test
    fun `should return enabled for first top lamp and disabled for other top lamps when top minutes count is 1`() {
        val clock = berlinClock.copy(topMinuteLamps = Lamps.TopMinutes(1))

        val clockState = mapper.map(clock)

        assertThat(clockState.topMinuteLampStates).isEqualTo(
            listOf(
                LampState.YELLOW_ENABLED, LampState.YELLOW_DISABLED,
                LampState.RED_DISABLED, LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED,
                LampState.RED_DISABLED, LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED,
                LampState.RED_DISABLED, LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED
            )
        )
    }

    @Test
    fun `should return enabled for first two top lamps and disabled for other top lamps when top minutes count is 2`() {
        val clock = berlinClock.copy(topMinuteLamps = Lamps.TopMinutes(2))

        val clockState = mapper.map(clock)

        assertThat(clockState.topMinuteLampStates).isEqualTo(
            listOf(
                LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED,
                LampState.RED_DISABLED, LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED,
                LampState.RED_DISABLED, LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED,
                LampState.RED_DISABLED, LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED
            )
        )
    }

    @Test
    fun `should return enabled for first three top lamps and disabled for other top lamps when top minutes count is 3`() {
        val clock = berlinClock.copy(topMinuteLamps = Lamps.TopMinutes(3))

        val clockState = mapper.map(clock)

        assertThat(clockState.topMinuteLampStates).isEqualTo(
            listOf(
                LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED,
                LampState.RED_ENABLED, LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED,
                LampState.RED_DISABLED, LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED,
                LampState.RED_DISABLED, LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED
            )
        )
    }

    @Test
    fun `should return enabled for first four top lamps and disabled for other top lamps when top minutes count is 4`() {
        val clock = berlinClock.copy(topMinuteLamps = Lamps.TopMinutes(4))

        val clockState = mapper.map(clock)

        assertThat(clockState.topMinuteLampStates).isEqualTo(
            listOf(
                LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED,
                LampState.RED_ENABLED, LampState.YELLOW_ENABLED, LampState.YELLOW_DISABLED,
                LampState.RED_DISABLED, LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED,
                LampState.RED_DISABLED, LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED
            )
        )
    }

    @Test
    fun `should return enabled for first five top lamps and disabled for other top lamps when top minutes count is 5`() {
        val clock = berlinClock.copy(topMinuteLamps = Lamps.TopMinutes(5))

        val clockState = mapper.map(clock)

        assertThat(clockState.topMinuteLampStates).isEqualTo(
            listOf(
                LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED,
                LampState.RED_ENABLED, LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED,
                LampState.RED_DISABLED, LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED,
                LampState.RED_DISABLED, LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED
            )
        )
    }

    @Test
    fun `should return enabled for first six top lamps and disabled for other top lamps when top minutes count is 6`() {
        val clock = berlinClock.copy(topMinuteLamps = Lamps.TopMinutes(6))

        val clockState = mapper.map(clock)

        assertThat(clockState.topMinuteLampStates).isEqualTo(
            listOf(
                LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED,
                LampState.RED_ENABLED, LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED,
                LampState.RED_ENABLED, LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED,
                LampState.RED_DISABLED, LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED
            )
        )
    }

    @Test
    fun `should return enabled for first seven top lamps and disabled for other top lamps when top minutes count is 7`() {
        val clock = berlinClock.copy(topMinuteLamps = Lamps.TopMinutes(7))

        val clockState = mapper.map(clock)

        assertThat(clockState.topMinuteLampStates).isEqualTo(
            listOf(
                LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED,
                LampState.RED_ENABLED, LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED,
                LampState.RED_ENABLED, LampState.YELLOW_ENABLED, LampState.YELLOW_DISABLED,
                LampState.RED_DISABLED, LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED
            )
        )
    }

    @Test
    fun `should return enabled for first eight top lamps and disabled for other top lamps when top minutes count is 8`() {
        val clock = berlinClock.copy(topMinuteLamps = Lamps.TopMinutes(8))

        val clockState = mapper.map(clock)

        assertThat(clockState.topMinuteLampStates).isEqualTo(
            listOf(
                LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED,
                LampState.RED_ENABLED, LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED,
                LampState.RED_ENABLED, LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED,
                LampState.RED_DISABLED, LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED
            )
        )
    }

    @Test
    fun `should return enabled for first nine top lamps and disabled for other top lamps when top minutes count is 9`() {
        val clock = berlinClock.copy(topMinuteLamps = Lamps.TopMinutes(9))

        val clockState = mapper.map(clock)

        assertThat(clockState.topMinuteLampStates).isEqualTo(
            listOf(
                LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED,
                LampState.RED_ENABLED, LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED,
                LampState.RED_ENABLED, LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED,
                LampState.RED_ENABLED, LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED
            )
        )
    }

    @Test
    fun `should return enabled for first ten top lamps and disabled for last top lamp when top minutes count is 10`() {
        val clock = berlinClock.copy(topMinuteLamps = Lamps.TopMinutes(10))

        val clockState = mapper.map(clock)

        assertThat(clockState.topMinuteLampStates).isEqualTo(
            listOf(
                LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED,
                LampState.RED_ENABLED, LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED,
                LampState.RED_ENABLED, LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED,
                LampState.RED_ENABLED, LampState.YELLOW_ENABLED, LampState.YELLOW_DISABLED
            )
        )
    }

    @Test
    fun `should return enabled for all top lamps when top minutes count is 11`() {
        val clock = berlinClock.copy(topMinuteLamps = Lamps.TopMinutes(11))

        val clockState = mapper.map(clock)

        assertThat(clockState.topMinuteLampStates).isEqualTo(
            listOf(
                LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED,
                LampState.RED_ENABLED, LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED,
                LampState.RED_ENABLED, LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED,
                LampState.RED_ENABLED, LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED
            )
        )
    }

    @Test
    fun `should return disabled yellow color for all bottom lamps when bottom minutes count is 0`() {
        val clock = berlinClock.copy(bottomMinuteLamps = Lamps.BottomMinutes(0))

        val clockState = mapper.map(clock)

        assertThat(clockState.bottomMinuteLampStates).isEqualTo(
            listOf(
                LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED,
                LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED
            )
        )
    }

    @Test
    fun `should return enabled color for first bottom lamp and disabled color for other bottom lamps when bottom minutes count is 1`() {
        val clock = berlinClock.copy(bottomMinuteLamps = Lamps.BottomMinutes(1))

        val clockState = mapper.map(clock)

        assertThat(clockState.bottomMinuteLampStates).isEqualTo(
            listOf(
                LampState.YELLOW_ENABLED, LampState.YELLOW_DISABLED,
                LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED
            )
        )
    }

    @Test
    fun `should return enabled color for first two bottom lamp and disabled color for other bottom lamps when bottom minutes count is 2`() {
        val clock = berlinClock.copy(bottomMinuteLamps = Lamps.BottomMinutes(2))

        val clockState = mapper.map(clock)

        assertThat(clockState.bottomMinuteLampStates).isEqualTo(
            listOf(
                LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED,
                LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED
            )
        )
    }

    @Test
    fun `should return enabled color for first three bottom lamp and disabled color for last bottom lamp when bottom minutes count is 3`() {
        val clock = berlinClock.copy(bottomMinuteLamps = Lamps.BottomMinutes(3))

        val clockState = mapper.map(clock)

        assertThat(clockState.bottomMinuteLampStates).isEqualTo(
            listOf(
                LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED,
                LampState.YELLOW_ENABLED, LampState.YELLOW_DISABLED
            )
        )
    }

    @Test
    fun `should return enabled color for all bottom lamps when bottom minutes count is 4`() {
        val clock = berlinClock.copy(bottomMinuteLamps = Lamps.BottomMinutes(4))

        val clockState = mapper.map(clock)

        assertThat(clockState.bottomMinuteLampStates).isEqualTo(
            listOf(
                LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED,
                LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED
            )
        )
    }

    @Test
    fun `should return formatted time for given time`() {
        val sTime = "08:30:30"
        val clock = berlinClock.copy(
            time = sTime
        )

        val clockState = mapper.map(clock)

        assertThat(clockState.time).isEqualTo(sTime)
    }
}