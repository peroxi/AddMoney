package com.addmoney.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.addmoney.BR
import com.addmoney.R
import com.addmoney.databinding.FragmentCardDetailsBinding
import com.addmoney.viewmodel.activityviewmodel.AddBalanceActivityViewModel
import com.addmoney.viewmodel.fragmentviewmodel.CardDetailsFragmentViewModel


class CardDetailsFragment : Fragment() {
    private val viewModel: CardDetailsFragmentViewModel by viewModels()
    private val sharedViewModel: AddBalanceActivityViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentCardDetailsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_card_details, container, false)
        viewModel.getScreenData()?.observe(viewLifecycleOwner,
            Observer {
                sharedViewModel.screenLiveData.value = it
            })
        binding.setVariable(BR.screen, viewModel)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = CardDetailsFragment()
    }
}