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
import com.addmoney.databinding.FragmentCardDetailsBinding
import com.addmoney.view.util.FragmentInteractionListener
import com.addmoney.viewmodel.activityviewmodel.MainActivityViewModel
import com.addmoney.viewmodel.fragmentviewmodel.CardDetailsFragmentViewModel


class CardDetailsFragment : Fragment() {
    private val viewModel: CardDetailsFragmentViewModel by viewModels()
    private var mListener: FragmentInteractionListener? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentCardDetailsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_card_details, container, false)
        viewModel.getScreenData()?.observe(viewLifecycleOwner,
            Observer {
                when(it) {
                    MainActivityViewModel.NavigationConstants.AMOUNT.getValue() -> {
                        mListener?.setFragment(AmountFragment.newInstance())
                    }
                }
            })
        binding.setVariable(BR.screen, viewModel)
        return binding.root
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
        fun newInstance() = CardDetailsFragment()
    }
}