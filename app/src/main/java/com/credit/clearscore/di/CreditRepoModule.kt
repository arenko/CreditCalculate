package com.credit.clearscore.di

import com.credit.clearscore.domain.repository.credit.CreditRepoInterface
import com.credit.clearscore.domain.repository.credit.CreditRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class CreditRepoModule {

    @Binds
    abstract fun bindRepoModule(
        creditRepository: CreditRepository
    ): CreditRepoInterface
}