package com.darkkillen.kotlinaac.ui.fragment

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.darkkillen.kotlinaac.R
import com.darkkillen.kotlinaac.databinding.FragmentMainBinding
import com.darkkillen.kotlinaac.ui.fragment.base.BaseFragment
import com.darkkillen.kotlinaac.viewmodel.fragment.MainFragmentViewModel

/**
 * Created by darkkillen on 9/28/2017 AD.
 */
class MainFragment : BaseFragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var mainFragmentViewModel : MainFragmentViewModel

    fun newInstance(): MainFragment {
        val fragment = MainFragment()
        val bundle = Bundle()
        fragment.arguments = bundle
        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<FragmentMainBinding>(inflater, R.layout.fragment_main, container, false).also {
                binding = it
            }.root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initial()
    }

    private fun initial() {
        mainFragmentViewModel = ViewModelProviders.of(this).get(MainFragmentViewModel::class.java)
    }
}