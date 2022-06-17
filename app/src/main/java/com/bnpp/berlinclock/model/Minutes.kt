package com.bnpp.berlinclock.model

import com.bnpp.berlinclock.LampColor

data class Minutes(
    val topLamps: List<LampColor> = defaultTop(),
    val bottomLamps: List<LampColor> = defaultBottom()
) {
    companion object{
        fun defaultTop() = MutableList(11){LampColor.OFF}
        fun defaultBottom() = MutableList(4){LampColor.OFF}
    }
}