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

class CardDetailsFragmentViewModel: BaseFragmentViewModel() {
    val text: ObservableField<String> = ObservableField("Card details")
    val cardIcon: ObservableInt = ObservableInt(R.drawable.icons_bank_cards)
    val cardNumber: ObservableField<String> = ObservableField()
    val cvCode: ObservableField<String> = ObservableField()
    val cardNumberIncorrectMessageShow: ObservableBoolean = ObservableBoolean(false)
    val cvCodeIncorrectMessageShow: ObservableBoolean = ObservableBoolean(false)
    private val cardNumberOk: ObservableBoolean = ObservableBoolean(false)
    private val cvCodeOk: ObservableBoolean = ObservableBoolean(false)

    init {
        cardNumber.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                cardNumber.get()?.let{
                    cardNumberIncorrectMessageShow.set(false)
                    validateCardNumber(it)
                }
            }
        })

        cvCode.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                cvCode.get()?.let{
                    cvCodeIncorrectMessageShow.set(false)
                    val isCvValid = InputValidatorUseCase.validateCvCode(it)
                    cvCodeOk.set(isCvValid)
                }
            }
        })
    }

    override fun navigateToAmount() {
        when(false) {
            cardNumberOk.get() -> {
                cardNumberIncorrectMessageShow.set(true)
                return
            }
            cvCodeOk.get() -> {
                cvCodeIncorrectMessageShow.set(true)
                return
            }
        }
        PaymentDetailsUseCase.storeCardNumber(cardNumber.get() ?: "")
        super.navigateToAmount()
    }

    private fun validateCardNumber(cardNumber: String) {
        InputValidatorUseCase.validateCard(cardNumber).let{
            cardNumberOk.set(it != null)
            val cardResId = CardSystemsHelper.getPaymentSystemIconIdByName(it?.getValue())
            cardIcon.set(cardResId)
        }
    }
}
