package com.addmoney.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.addmoney.BR
import com.addmoney.R
import com.addmoney.databinding.ActivityAddBalanceBinding
import com.addmoney.view.fragment.AddMoneyWithFragment
import com.addmoney.view.util.AddMoneyFragmentManager
import com.addmoney.view.util.FragmentInteractionListener
import com.addmoney.viewmodel.activityviewmodel.AddBalanceActivityViewModel

class AddBalanceActivity : AppCompatActivity(), FragmentInteractionListener {
    private val viewModel: AddBalanceActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityAddBalanceBinding = DataBindingUtil
            .setContentView(this, R.layout.activity_add_balance)
        binding.setVariable(BR.screen, viewModel)
        if(savedInstanceState == null) {
            setFragment(AddMoneyWithFragment.newInstance())
        }
    }

    override fun setFragment(fragment: Fragment, clearBackStack: Boolean) {
        val oldFragment = supportFragmentManager.findFragmentByTag(fragment::class.java.name)
        if (oldFragment == null) {
            AddMoneyFragmentManager.launchAddMoneyFragment(supportFragmentManager, R.id.fragmentContainer, fragment, clearBackStack)
        } else {
            AddMoneyFragmentManager.launchAddMoneyFragment(supportFragmentManager, R.id.fragmentContainer, oldFragment, clearBackStack)
        }

    }
}