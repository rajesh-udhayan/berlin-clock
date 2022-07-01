package com.bnpp.berlinclock

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.runner.AndroidJUnitRunner
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
}