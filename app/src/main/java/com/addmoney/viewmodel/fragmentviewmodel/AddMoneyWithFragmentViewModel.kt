package com.addmoney.viewmodel.fragmentviewmodel

import androidx.databinding.ObservableField
import com.addmoney.viewmodel.fragmentviewmodel.base.BaseFragmentViewModel

class AddMoneyWithFragmentViewModel: BaseFragmentViewModel() {
    val text: ObservableField<String> = ObservableField("With Current Card")
}