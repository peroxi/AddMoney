package com.addmoney.view.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.addmoney.BR
import com.addmoney.R
import com.addmoney.databinding.ActivityAddBalanceBinding
import com.addmoney.view.fragment.*
import com.addmoney.view.util.AddMoneyFragmentManager
import com.addmoney.viewmodel.activityviewmodel.AddBalanceActivityViewModel
import com.addmoney.viewmodel.activityviewmodel.MainActivityViewModel

class AddBalanceActivity : AppCompatActivity(){
    private val viewModel: AddBalanceActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityAddBalanceBinding = DataBindingUtil
            .setContentView(this, R.layout.activity_add_balance)
        binding.setVariable(BR.screen, viewModel)
        viewModel.screenLiveData.observe(this, Observer {
            when(it) {
                MainActivityViewModel.NavigationConstants.CARD_DETAILS.getValue() -> setFragment(CardDetailsFragment.newInstance())
                MainActivityViewModel.NavigationConstants.VERIFY_BY_PHONE.getValue() -> setFragment(VerifyByPhoneFragment.newInstance())
                MainActivityViewModel.NavigationConstants.ADD_MONEY_WITH.getValue() -> setFragment(AddMoneyWithFragment.newInstance())
                MainActivityViewModel.NavigationConstants.AMOUNT.getValue() -> setFragment(AmountFragment.newInstance())
                MainActivityViewModel.NavigationConstants.RESULT.getValue() -> setFragment(ResultFragmentFragment.newInstance(), true)
            }
        })
        if(savedInstanceState == null) {
            setFragment(AddMoneyWithFragment.newInstance())
        }
    }

    private fun setFragment(fragment: Fragment, clearBackStack: Boolean = false) {
        val oldFragment = supportFragmentManager.findFragmentByTag(fragment::class.java.name)
        if (oldFragment == null) {
            AddMoneyFragmentManager.launchAddMoneyFragment(supportFragmentManager, R.id.fragmentContainer, fragment, clearBackStack)
        } else {
            AddMoneyFragmentManager.launchAddMoneyFragment(supportFragmentManager, R.id.fragmentContainer, oldFragment, clearBackStack)
        }

    }
}