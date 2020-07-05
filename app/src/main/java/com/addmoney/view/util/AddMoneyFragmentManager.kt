package com.addmoney.view.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE
import androidx.fragment.app.FragmentTransaction

object AddMoneyFragmentManager {

    fun launchAddMoneyFragment(
        fragmentManager: FragmentManager,
        containerId: Int,
        fragment: Fragment,
        clearBackStack: Boolean) {
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(containerId, fragment, fragment::class.java.name)
        fragmentTransaction.addToBackStack(null)
        if(clearBackStack) {
            fragmentManager.popBackStack(0, POP_BACK_STACK_INCLUSIVE)
        }
        fragmentTransaction.commit()
    }
}