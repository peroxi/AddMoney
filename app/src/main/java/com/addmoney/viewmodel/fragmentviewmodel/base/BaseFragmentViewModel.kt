package com.addmoney.viewmodel.fragmentviewmodel.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.addmoney.viewmodel.activityviewmodel.MainActivityViewModel

abstract class BaseFragmentViewModel: ViewModel() {
    private var screenLiveData: MutableLiveData<Int>? = null

    open fun getScreenData(): MutableLiveData<Int>? {
        screenLiveData = MutableLiveData()
        return screenLiveData
    }

    open fun navigateToAddMoneyWith() {
        screenLiveData?.value = MainActivityViewModel.NavigationConstants.ADD_MONEY_WITH.getValue()
    }

    open fun navigateToAmount() {
        screenLiveData?.value = MainActivityViewModel.NavigationConstants.AMOUNT.getValue()
    }

    open fun navigateToCardDetails() {
        screenLiveData?.value = MainActivityViewModel.NavigationConstants.CARD_DETAILS.getValue()
    }

    open fun navigateToVerifyByPhone() {
        screenLiveData?.value = MainActivityViewModel.NavigationConstants.VERIFY_BY_PHONE.getValue()
    }

    open fun navigateToResult() {
        screenLiveData?.value = MainActivityViewModel.NavigationConstants.RESULT.getValue()
    }
}
