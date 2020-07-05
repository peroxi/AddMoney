package com.addmoney.viewmodel.activityviewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainActivityViewModel: ViewModel() {
    private var screenLiveData: MutableLiveData<Int>? = null
    var loadedData: List<out Objects> = listOf()
    val balance: ObservableField<String> = ObservableField()

    fun getScreenData(): MutableLiveData<Int>? {
        if (screenLiveData == null) {
            screenLiveData = MutableLiveData()
        }
        return screenLiveData
    }

    fun addBalance() {
        screenLiveData?.value =
            NavigationConstants.INIT_BALANCE_ADDING.getValue()
    }

    enum class NavigationConstants{
        INIT_BALANCE_ADDING(0),
        ADD_MONEY_WITH(1),
        AMOUNT(2),
        CARD_DETAILS(3),
        VERIFY_BY_PHONE(4),
        RESULT(5);

        private val value: Int

        constructor(value: Int) {
            this.value = value
        }

        fun getValue(): Int {
            return value
        }
    }
}