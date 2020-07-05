package com.addmoney.model.usecase

import com.addmoney.model.constants.CardSystemsNames
import com.addmoney.model.validator.CreditCardValidator

object InputValidatorUseCase {
    fun validateCard(cardNumber: String): CardSystemsNames?{
        return CreditCardValidator.validateCreditCardNumber(cardNumber)
    }

    fun validateCvCode(cvCode: String): Boolean = CreditCardValidator.validateCvCode(cvCode)
}