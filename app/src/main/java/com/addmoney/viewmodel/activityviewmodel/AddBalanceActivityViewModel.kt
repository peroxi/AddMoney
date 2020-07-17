package com.addmoney.viewmodel.activityviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddBalanceActivityViewModel: ViewModel() {
    val screenLiveData: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
}