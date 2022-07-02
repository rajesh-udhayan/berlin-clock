package com.bnpp.berlinclock

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.bnpp.berlinclock.ui.theme.BerlinClockTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class BerlinClockActivityTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            BerlinClockTheme {
                MainView()
            }
        }
    }

    @Test
    fun shouldDisplayAppTitle() {
        with(composeTestRule) {
            val title = onNodeWithText("BerlinClock")

            title.assertIsDisplayed()
        }
    }

    @Test
    fun shouldDisplaySecondsLamp(){
        with(composeTestRule){
            val secondsButton = onNodeWithTag("secondsLamp")

            secondsButton.assertIsDisplayed()
        }
    }

    @Test
    fun shouldDisplayHourLamps(){
        with(composeTestRule){
            val topHour1 = onNodeWithTag("topHourLamp1")
            val topHour2 = onNodeWithTag("topHourLamp2")
            val topHour3 = onNodeWithTag("topHourLamp3")
            val topHour4 = onNodeWithTag("topHourLamp4")
            val bottomHour1 = onNodeWithTag("bottomHourLamp1")
            val bottomHour2 = onNodeWithTag("bottomHourLamp2")
            val bottomHour3 = onNodeWithTag("bottomHourLamp3")
            val bottomHour4 = onNodeWithTag("bottomHourLamp4")

            topHour1.assertIsDisplayed()
            topHour2.assertIsDisplayed()
            topHour3.assertIsDisplayed()
            topHour4.assertIsDisplayed()
            bottomHour1.assertIsDisplayed()
            bottomHour2.assertIsDisplayed()
            bottomHour3.assertIsDisplayed()
            bottomHour4.assertIsDisplayed()
        }
    }
}