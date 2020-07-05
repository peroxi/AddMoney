package com.addmoney.viewmodel.fragmentviewmodel

import android.os.Build
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.addmoney.R
import com.addmoney.model.usecase.InputValidatorUseCase
import com.addmoney.model.usecase.PaymentDetailsUseCase
import com.addmoney.viewmodel.fragmentviewmodel.base.BaseFragmentViewModel
import com.addmoney.viewmodel.util.CardSystemsHelper

class VerifyByPhoneFragmentViewModel: BaseFragmentViewModel() {
    val text: ObservableField<String> = ObservableField("Verify by Phone")
    val cardIcon: ObservableInt = ObservableInt(R.drawable.icons_bank_cards)

    fun updateValues() {
        val cardNumberString = PaymentDetailsUseCase.retrieveCardNumber()
        InputValidatorUseCase.validateCard(cardNumberString)?.let{
            val cardResId = CardSystemsHelper.getPaymentSystemIconIdByName(it.getValue())
            cardIcon.set(cardResId)
        }
    }
}