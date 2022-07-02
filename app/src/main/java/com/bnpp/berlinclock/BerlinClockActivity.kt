package com.bnpp.berlinclock

import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bnpp.berlinclock.model.Hours
import com.bnpp.berlinclock.model.Minutes
import com.bnpp.berlinclock.ui.theme.BerlinClockTheme
import com.bnpp.berlinclock.ui.theme.redEnabled
import com.bnpp.berlinclock.ui.theme.yellowDisabled
import com.bnpp.berlinclock.ui.theme.yellowEnabled
import java.text.SimpleDateFormat
import java.util.*

private val currentTime = mutableStateOf("00:00:00")

class BerlinClockActivity : ComponentActivity() {

    private lateinit var timer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startTimer()
        setContent {
            BerlinClockTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MainView()
                }
            }
        }
    }

    private fun startTimer() {
        timer = object : CountDownTimer(COUNT_DOWN_MILLIS, COUNT_DOWN_INTERVAL) {
            override fun onTick(millisUntilFinished: Long){
                val mTime: String = SimpleDateFormat(TIME_FORMAT, Locale.getDefault()).format(
                    Date()
                )
                currentTime.value = mTime
            }
            override fun onFinish() {
                start()
            }
        }
        timer.start()
    }

    companion object {
        const val COUNT_DOWN_MILLIS = 600000L
        const val COUNT_DOWN_INTERVAL = 1000L
        const val TIME_FORMAT = "HH:mm:ss"
    }
}

@Composable
fun MainView() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                }
            )
        }
    ) {
        BerlinClockView()
    }
}

@Composable
fun BerlinClockView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val enabled = true
        val color = if (enabled) yellowEnabled else yellowDisabled
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .testTag("secondsLamp")
                    .background(color = color, shape = CircleShape)
            )
        val topHours = Hours().topLamps
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            topHours.forEachIndexed { i, lamp ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(80.dp)
                        .background(color = redEnabled, shape = RoundedCornerShape(4.dp))
                        .testTag("topHourLamp${i + 1}")
                )
            }
        }
        val bottomHours = Hours().topLamps
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            bottomHours.forEachIndexed { i, lamp ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(80.dp)
                        .background(color = redEnabled, shape = RoundedCornerShape(4.dp))
                        .testTag("bottomHourLamp${i + 1}")
                )
            }
        }

        val topMinutes = Minutes().topLamps
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            topMinutes.forEachIndexed { i, lamp ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(80.dp)
                        .background(color = redEnabled, shape = RoundedCornerShape(4.dp))
                        .testTag("topMinutesLamp${i + 1}")
                )
            }
        }

        val bottomMinutes = Minutes().bottomLamps
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            bottomMinutes.forEachIndexed { i, lamp ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(80.dp)
                        .background(color = redEnabled, shape = RoundedCornerShape(4.dp))
                        .testTag("bottomMinutesLamp${i + 1}")
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))
        val mTime by currentTime
        Text(
            modifier = Modifier.testTag("timeText"),
            text = mTime,
            fontSize = 30.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
    }
}