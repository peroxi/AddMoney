package com.addmoney.view.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.addmoney.BR
import com.addmoney.R
import com.addmoney.databinding.FragmentAmountBinding
import com.addmoney.view.util.FragmentInteractionListener
import com.addmoney.viewmodel.activityviewmodel.MainActivityViewModel
import com.addmoney.viewmodel.fragmentviewmodel.AmountFragmentViewModel

class AmountFragment : Fragment() {
    private val viewModel: AmountFragmentViewModel by viewModels()
    private var mListener: FragmentInteractionListener? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentAmountBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_amount, container, false)
        viewModel.updateValues()
        viewModel.getScreenData()?.observe(viewLifecycleOwner,
            Observer {
                when(it) {
                    MainActivityViewModel.NavigationConstants.VERIFY_BY_PHONE.getValue() -> {
                        mListener?.setFragment(VerifyByPhoneFragment.newInstance())
                    }
                    MainActivityViewModel.NavigationConstants.ADD_MONEY_WITH.getValue() -> {
                        mListener?.setFragment(AddMoneyWithFragment.newInstance())
                    }
                }
            })
        binding.setVariable(BR.screen, viewModel)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.updateValues()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is FragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context.toString() + " must implement FragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = AmountFragment()
    }
}