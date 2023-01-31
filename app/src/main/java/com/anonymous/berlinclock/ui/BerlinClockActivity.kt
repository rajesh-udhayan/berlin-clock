package com.anonymous.berlinclock.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.anonymous.berlinclock.ui.theme.BerlinClockTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class BerlinClockActivity : ComponentActivity() {

    private val viewModel: BerlinClockViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val berlinClockState by viewModel.berlinClockState.collectAsState()
            BerlinClockTheme {
                Surface(color = MaterialTheme.colors.background) {
                    BerlinClockView(clockState = berlinClockState)
                }
            }
        }
    }
}