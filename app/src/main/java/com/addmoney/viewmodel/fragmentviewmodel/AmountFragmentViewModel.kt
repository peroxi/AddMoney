package com.addmoney.viewmodel.fragmentviewmodel

import androidx.databinding.Observable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.addmoney.R
import com.addmoney.model.usecase.InputValidatorUseCase
import com.addmoney.model.usecase.PaymentDetailsUseCase
import com.addmoney.viewmodel.fragmentviewmodel.base.BaseFragmentViewModel
import com.addmoney.viewmodel.util.CardSystemsHelper

class AmountFragmentViewModel: BaseFragmentViewModel() {
    val amount: ObservableField<String> = ObservableField()
    val cardNumber: ObservableField<String> = ObservableField()
    val allowNext: ObservableBoolean = ObservableBoolean(false)
    val cardIcon: ObservableInt = ObservableInt(R.drawable.icons_bank_cards)

    init {
        amount.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                allowNext.set(amount.get()?.length ?: 0 > 0)
            }
        })
    }

    fun updateValues() {
        val cardNumberString = PaymentDetailsUseCase.retrieveCardNumber()
        InputValidatorUseCase.validateCard(cardNumberString)?.let{
            val cardResId = CardSystemsHelper.getPaymentSystemIconIdByName(it.getValue())
            cardIcon.set(cardResId)
            cardNumber.set(cardNumberString.replace(cardNumberString.substring(0, 12), "**** **** **** "))
        }
    }
}