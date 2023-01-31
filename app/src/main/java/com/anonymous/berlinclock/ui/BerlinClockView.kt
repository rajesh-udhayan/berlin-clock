package com.anonymous.berlinclock.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anonymous.berlinclock.model.BerlinClockUIModel
import com.anonymous.berlinclock.model.LampState

@Composable
fun BerlinClockView(clockState: BerlinClockUIModel){
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val modifier = Modifier.weight(1f)
        SecondsLamp(modifier = modifier, lampState = clockState.secondsLampState)
        RectangleLamps(modifier = modifier, lampStates = clockState.topHourLampStates)
        RectangleLamps(modifier = modifier, lampStates =clockState.bottomHourLampStates)
        RectangleLamps(modifier = modifier, lampStates =clockState.topMinuteLampStates)
        RectangleLamps(modifier = modifier, lampStates =clockState.bottomMinuteLampStates)

        Spacer(modifier = modifier)

        TimerText(modifier = modifier, time = clockState.time)
    }

}

@Composable
private fun SecondsLamp(modifier: Modifier, lampState: LampState) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .size(100.dp)
            .background(color = lampState.color, shape = CircleShape)
    )
}

@Composable
private fun RectangleLamps(modifier: Modifier, lampStates: List<LampState>) {
    Row(
        modifier = modifier.fillMaxWidth().padding(top = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        lampStates.forEach { lampState ->
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(80.dp)
                    .background(color = lampState.color, shape = RoundedCornerShape(4.dp))
            )
        }
    }
}

@Composable
private fun TimerText(modifier: Modifier, time: String) {
    Text(
        modifier = modifier,
        text = time,
        fontSize = 30.sp,
        color = Color.Black,
        fontWeight = FontWeight.Bold
    )
}