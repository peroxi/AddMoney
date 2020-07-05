package com.addmoney.view.fragment

import android.content.Context
import android.os.Build
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
import com.addmoney.databinding.FragmentVerifyByPhoneBinding
import com.addmoney.view.util.FragmentInteractionListener
import com.addmoney.viewmodel.activityviewmodel.MainActivityViewModel
import com.addmoney.viewmodel.fragmentviewmodel.VerifyByPhoneFragmentViewModel


class VerifyByPhoneFragment : Fragment() {
    private val viewModel: VerifyByPhoneFragmentViewModel by viewModels()
    private var mListener: FragmentInteractionListener? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentVerifyByPhoneBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_verify_by_phone, container, false)
        viewModel.getScreenData()?.observe(viewLifecycleOwner,
            Observer {
                when(it) {
                    MainActivityViewModel.NavigationConstants.RESULT.getValue() -> {
                        mListener?.setFragment(ResultFragmentFragment.newInstance(), true)
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
        fun newInstance() = VerifyByPhoneFragment()
    }
}