package com.credit.clearscore

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.work.Configuration
import androidx.work.testing.SynchronousExecutor
import androidx.work.testing.WorkManagerTestInitHelper
import com.credit.clearscore.data.model.credit.CreditResponse
import com.credit.clearscore.domain.usecase.credit.CreditUseCase
import com.credit.clearscore.ui.credit.CreditViewModel
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CreditResultTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: CreditViewModel

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getTargetContext()
        val config = Configuration.Builder()
            .setMinimumLoggingLevel(Log.DEBUG)
            .setExecutor(SynchronousExecutor())
            .build()
        WorkManagerTestInitHelper.initializeTestWorkManager(context, config)

        val fakeCreditRepository = FakeCreditRepository()
        val getCreditUseCase = CreditUseCase(fakeCreditRepository)
        viewModel = CreditViewModel(getCreditUseCase)
    }

    @Test
    fun getArtObjects_returnsCurrentList() {
        val credit = CreditResponse("PASS")

        val creditResponse = viewModel.getCreditResult().getOrAwaitValue()
        assertThat(creditResponse).isEqualTo(credit)

    }

}









