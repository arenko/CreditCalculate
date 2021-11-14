package com.credit.clearscore.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.credit.clearscore.BR

abstract class BaseFragment<vm : ViewModel, db : ViewDataBinding>(@LayoutRes private val fragmentLayout: Int,
                                                                  private val viewModelClass: Class<vm>) : Fragment() {

    lateinit var binding: db
    val viewModel by lazy {
        ViewModelProvider(this).get(viewModelClass)
    }

    abstract fun init()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        doDataBinding(inflater, container)
        init()
        return binding.root
    }

    fun doDataBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, fragmentLayout, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.setVariable(BR.viewModel, viewModel)
    }

    override fun onResume() {
        super.onResume()
    }
}