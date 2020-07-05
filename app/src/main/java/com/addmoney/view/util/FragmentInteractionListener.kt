package com.addmoney.view.util

import androidx.fragment.app.Fragment

interface FragmentInteractionListener {
    fun setFragment(fragment: Fragment, clearBackStack: Boolean = false)
}