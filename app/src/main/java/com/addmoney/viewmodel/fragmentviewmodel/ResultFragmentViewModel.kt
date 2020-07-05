package com.addmoney.viewmodel.fragmentviewmodel

import androidx.databinding.ObservableField
import com.addmoney.viewmodel.fragmentviewmodel.base.BaseFragmentViewModel

class ResultFragmentViewModel: BaseFragmentViewModel() {
    val text: ObservableField<String> = ObservableField("Result Success!!!")
}