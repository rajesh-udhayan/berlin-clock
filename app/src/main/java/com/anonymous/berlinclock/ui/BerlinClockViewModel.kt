package com.anonymous.berlinclock.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anonymous.berlinclock.domain.parser.BerlinClockParser
import com.anonymous.berlinclock.model.BerlinClockUIModel
import com.anonymous.berlinclock.model.mapper.BerlinClockUIMapper
import com.anonymous.berlinclock.utils.Constants.TIMER_DELAY
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class BerlinClockViewModel(
    private val parser: BerlinClockParser,
    private val mapper: BerlinClockUIMapper
) : ViewModel() {

    private val mBerlinClockState = MutableStateFlow(BerlinClockUIModel.initialState())
    val berlinClockState: StateFlow<BerlinClockUIModel> = mBerlinClockState.asStateFlow()

    init {
        viewModelScope.launch {
            while (true) {
                updateTime(LocalDateTime.now())
                delay(TIMER_DELAY)
            }
        }
    }

    fun updateTime(time: LocalDateTime) {
        val berlinClockValues = parser.parse(time)
        val berlinClockState = mapper.map(berlinClockValues)

        mBerlinClockState.value = berlinClockState
    }
}