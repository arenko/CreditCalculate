package com.credit.clearscore.ui.credit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.credit.clearscore.data.model.credit.CreditResponse
import com.credit.clearscore.domain.usecase.credit.CreditUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreditViewModel @Inject constructor(private val creditUseCase: CreditUseCase) : ViewModel() {

    fun getCreditResult() = liveData {
        emit(creditUseCase.getCreditResult())
    }
}