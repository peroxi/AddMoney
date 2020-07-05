package com.addmoney.model.validator

import com.addmoney.model.constants.CardSystemsNames
import java.util.regex.Matcher
import java.util.regex.Pattern

object CreditCardValidator {
    fun validateCreditCardNumber(str: String ): CardSystemsNames? {

        val regex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" +
                "(?<mastercard>5[1-5][0-9]{14})|" +
                "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" +
                "(?<amex>3[47][0-9]{13})|" +
                "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" +
                "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$"

        val pattern: Pattern = Pattern.compile(regex)

        //Strip all hyphens
        var temp = str
        temp = str.replace("-".toRegex(), "")

        //Match the card
        val matcher: Matcher = pattern.matcher(temp)
        System.out.println("Card***" + matcher.matches())
        if (matcher.matches()) {
            //If card is valid then verify which group it belong
            for(name: CardSystemsNames in CardSystemsNames.values()){
                System.out.println("Card*** "+ name.getValue() + matcher.group(name.getValue()))
                matcher.group(name.getValue())?.let {
                    return name
                }
            }

        }
        return null
    }

    fun validateCvCode(cvCode: String): Boolean = cvCode.length == 3
}