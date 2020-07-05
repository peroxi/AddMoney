package com.addmoney.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.addmoney.BR
import com.addmoney.R
import com.addmoney.databinding.ActivityMainBinding
import com.addmoney.viewmodel.activityviewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil
            .setContentView(this, R.layout.activity_main)
        binding.setVariable(BR.screen, viewModel)
        viewModel.getScreenData()?.observe(this,
            Observer<Int> {
                when(it) {
                    MainActivityViewModel.NavigationConstants.INIT_BALANCE_ADDING.getValue() -> {
                        val addBalanceIntent: Intent = Intent(this, AddBalanceActivity::class.java)
                        startActivity(addBalanceIntent)
                        finish()
                    }
                }
            })
    }
}