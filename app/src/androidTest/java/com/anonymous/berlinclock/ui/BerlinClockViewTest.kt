package com.anonymous.berlinclock.ui

import androidx.compose.ui.test.junit4.createComposeRule
import com.anonymous.berlinclock.model.BerlinClockUIModel
import com.anonymous.berlinclock.model.LampState
import com.anonymous.berlinclock.ui.theme.BerlinClockTheme
import com.anonymous.berlinclock.utils.Constants
import com.karumi.shot.ScreenshotTest
import org.junit.Rule
import org.junit.Test

class BerlinClockViewTest: ScreenshotTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val berlinClockUIModel = BerlinClockUIModel.initialState()

    @Test
    fun shouldShowDisabledYellowColorForSecondsLampWhenStateIsDisabled() {
        with(composeTestRule){
            setContent {
                BerlinClockTheme {
                    BerlinClockView(berlinClockUIModel)
                }
            }

            compareScreenshot(this)
        }
    }

    @Test
    fun shouldShowEnabledYellowColorForSecondsLampWhenStateIsEnabled() {
        val clockState = berlinClockUIModel.copy(secondsLampState = LampState.YELLOW_ENABLED)

        with(composeTestRule){
            setContent {
                BerlinClockTheme {
                    BerlinClockView(clockState)
                }
            }

            compareScreenshot(this)
        }
    }

    @Test
    fun shouldShowRespectiveEnabledAndDisabledColorForTopHoursLamp() {
        val clockState = berlinClockUIModel.copy(
            topHourLampStates = listOf(
                LampState.RED_ENABLED, LampState.RED_ENABLED,
                LampState.RED_DISABLED, LampState.RED_DISABLED
            )
        )

        with(composeTestRule) {
            setContent {
                BerlinClockTheme {
                    BerlinClockView(clockState)
                }
            }

            compareScreenshot(this)
        }
    }

    @Test
    fun shouldShowRespectiveEnabledAndDisabledColorForBottomHoursLamp() {
        val clockState = berlinClockUIModel.copy(
            bottomHourLampStates = listOf(
                LampState.RED_ENABLED, LampState.RED_ENABLED,
                LampState.RED_ENABLED, LampState.RED_DISABLED
            )
        )

        with(composeTestRule) {
            setContent {
                BerlinClockTheme {
                    BerlinClockView(clockState)
                }
            }

            compareScreenshot(this)
        }
    }

    @Test
    fun shouldShowRespectiveEnabledAndDisabledColorForTopMinutesLamp() {
        val clockState = berlinClockUIModel.copy(
            topMinuteLampStates = listOf(
                LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED,
                LampState.RED_ENABLED, LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED,
                LampState.RED_DISABLED, LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED,
                LampState.RED_DISABLED, LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED
            )
        )

        with(composeTestRule) {
            setContent {
                BerlinClockTheme {
                    BerlinClockView(clockState)
                }
            }

            compareScreenshot(this)
        }
    }

    @Test
    fun shouldShowRespectiveEnabledAndDisabledColorForBottomMinutesLamp() {
        val clockState = berlinClockUIModel.copy(
            bottomMinuteLampStates = listOf(
                LampState.YELLOW_ENABLED, LampState.YELLOW_ENABLED,
                LampState.YELLOW_DISABLED, LampState.YELLOW_DISABLED
            )
        )

        with(composeTestRule) {
            setContent {
                BerlinClockTheme {
                    BerlinClockView(clockState)
                }
            }

            compareScreenshot(this)
        }
    }

    @Test
    fun shouldShowTime(){
        val clockState = berlinClockUIModel.copy(time = Constants.DEFAULT_TIME)

        with(composeTestRule) {
            setContent {
                BerlinClockTheme {
                    BerlinClockView(clockState)
                }
            }

            compareScreenshot(this)
        }
    }
}