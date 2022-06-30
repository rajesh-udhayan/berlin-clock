package com.bnpp.berlinclock.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bnpp.berlinclock.BerlinClock
import com.bnpp.berlinclock.model.BerlinClockData

class BerlinClockViewModel(private val berlinClock: BerlinClock): ViewModel() {

    private var mBerlinClockTime = MutableLiveData<BerlinClockData>()
    val berlinClockTime: LiveData<BerlinClockData> = mBerlinClockTime

    fun initBerlinClock(){
        mBerlinClockTime.postValue(BerlinClockData.default())
    }
}