package com.addmoney.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.addmoney.BR
import com.addmoney.R
import com.addmoney.databinding.FragmentResultFragmentBinding
import com.addmoney.viewmodel.fragmentviewmodel.ResultFragmentViewModel

class ResultFragmentFragment : Fragment() {
    private val viewModel: ResultFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentResultFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_result_fragment, container, false)
        binding.setVariable(BR.screen, viewModel)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ResultFragmentFragment()
    }
}