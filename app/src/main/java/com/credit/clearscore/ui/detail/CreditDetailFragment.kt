package com.credit.clearscore.ui.detail

import com.credit.clearscore.R
import com.credit.clearscore.base.BaseFragment
import com.credit.clearscore.data.Constants
import com.credit.clearscore.databinding.DetailFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreditDetailFragment :
    BaseFragment<CreditDetailViewModel, DetailFragmentBinding>(
        R.layout.detail_fragment,
        CreditDetailViewModel::class.java
    ) {

    var clientRef: String? = null
    var status: String? = null
    var scoreBand: String? = null

    override fun init() {
        if (arguments != null) {
            clientRef = requireArguments().getString(Constants.clientRef)
            status = requireArguments().getString(Constants.status)
            scoreBand = requireArguments().getString(Constants.scoreBand)
            initLayout()
        }
    }

    private fun initLayout() {
        binding.tvClientRef.text = resources.getString(R.string.client_ref, clientRef)
        binding.tvStatus.text = resources.getString(R.string.status, status)
        binding.tvScorebandDescription.text =
            resources.getString(R.string.score_band, scoreBand)
    }
}