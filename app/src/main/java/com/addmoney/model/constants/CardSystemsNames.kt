package com.addmoney.model.constants

enum class CardSystemsNames(private val value: String) {
    Mastercard("mastercard"),
    Visa("visa"),
    Discover("discover"),
    Amex("amex"),
    Diners("diners"),
    Jcb("jcb");

    fun getValue(): String {
        return value
    }
}