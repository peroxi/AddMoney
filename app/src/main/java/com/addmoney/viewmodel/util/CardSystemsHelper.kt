package com.addmoney.viewmodel.util

import com.addmoney.R
import com.addmoney.model.constants.CardSystemsNames

object CardSystemsHelper {
    fun getPaymentSystemIconIdByName(name: String?): Int {
        return when(name) {
            CardSystemsNames.Visa.getValue() -> R.drawable.icons_visa
            CardSystemsNames.Mastercard.getValue() -> R.drawable.icons_mastercard
            CardSystemsNames.Discover.getValue() -> R.drawable.icons_discover
            CardSystemsNames.Jcb.getValue() -> R.drawable.icons8_jcb
            else -> R.drawable.icons_bank_cards
        }
    }
}