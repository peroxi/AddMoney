package com.addmoney.model.usecase

import com.addmoney.model.datasource.PaymentDetailsDataSource

object PaymentDetailsUseCase {
    fun storeCardNumber(cardNumber: String){
        PaymentDetailsDataSource.cardNumber = cardNumber
    }

    fun retrieveCardNumber(): String = PaymentDetailsDataSource.cardNumber ?: ""
}