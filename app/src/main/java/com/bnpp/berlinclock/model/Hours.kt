package com.bnpp.berlinclock.model

import com.bnpp.berlinclock.LampColor

data class Hours(
    val topLamps: List<LampColor> = default(),
    val bottomLamps: List<LampColor> = default()
) {
    companion object {
        fun default() = MutableList(4) { LampColor.OFF }
    }
}

