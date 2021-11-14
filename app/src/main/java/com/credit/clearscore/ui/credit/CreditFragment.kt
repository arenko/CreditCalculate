package com.credit.clearscore.ui.credit

import android.graphics.Color
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.credit.clearscore.R
import com.credit.clearscore.base.BaseFragment
import com.credit.clearscore.data.Constants
import com.credit.clearscore.data.model.credit.CreditResponse
import com.credit.clearscore.databinding.MainFragmentBinding
import com.credit.clearscore.ext.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreditFragment :
    BaseFragment<CreditViewModel, MainFragmentBinding>(
        R.layout.main_fragment,
        CreditViewModel::class.java
    ) {

    override fun init() {
        binding.viewModel?.getCreditResult()?.observe(this, { creditResponse ->
            binding.loader.root.visibility = View.GONE
            if (creditResponse != null) {
                binding.clResult.visibility = View.VISIBLE
                context?.toast(creditResponse.accountIDVStatus.toString())
                if (creditResponse.accountIDVStatus.equals("PASS")) {
                    initCircle(
                        creditResponse.reportInfo.score,
                        creditResponse.reportInfo.maxScoreValue,
                        Color.GREEN
                    )
                } else {
                    initCircle(
                        creditResponse.reportInfo.score,
                        creditResponse.reportInfo.maxScoreValue,
                        Color.RED
                    )
                }
                initListener(creditResponse)
            } else {
                context?.toast("Error")
            }
        })
    }

    private fun initCircle(score: Int, maxScoreValue: Int, color: Int) {
        val percent = ((100 * score) / maxScoreValue).toFloat()
        binding.pie.apply {
            progressBarColor = color
            progress = percent
            setProgressWithAnimation(percent, 1000)
        }
        binding.tvCreditScore.text = score.toString()
        binding.tvCreditScoreMax.text = resources.getString(R.string.out_of, maxScoreValue)
    }

    private fun initListener(creditResponse: CreditResponse) {
        binding.pie.setOnClickListener { view ->
            view.findNavController().navigate(
                R.id.action_mainFragment_to_detailFragment, bundleOf(
                    Constants.clientRef to creditResponse.reportInfo.clientRef,
                    Constants.status to creditResponse.reportInfo.status,
                    Constants.scoreBand to creditResponse.reportInfo.equifaxScoreBandDescription
                )
            )
        }
    }
}