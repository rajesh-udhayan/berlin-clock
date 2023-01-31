package com.anonymous.berlinclock.model

import androidx.compose.ui.graphics.Color

enum class LampState(val color: Color) {
    YELLOW_DISABLED(Color(0xFF666633)),
    YELLOW_ENABLED(Color(0xFFFFFF33)),
    RED_DISABLED(Color(0xFF633330)),
    RED_ENABLED(Color(0xFFF33300))
}