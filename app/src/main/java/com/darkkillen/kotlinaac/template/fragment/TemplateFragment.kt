package com.darkkillen.kotlinaac.template.fragment

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.darkkillen.kotlinaac.R
import com.darkkillen.kotlinaac.databinding.FragmentTemplateBinding
import com.darkkillen.kotlinaac.ui.fragment.base.BaseFragment
import com.darkkillen.kotlinaac.template.viewmodel.TemplateViewModel

/**
 * Created by darkkillen on 9/28/2017 AD.
 */
class TemplateFragment : BaseFragment() {

    private lateinit var binding: FragmentTemplateBinding
    private lateinit var templateFragmentViewModel : TemplateViewModel

    fun newInstance(): TemplateFragment {
        val fragment = TemplateFragment()
        val bundle = Bundle()
        fragment.arguments = bundle
        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            DataBindingUtil.inflate<FragmentTemplateBinding>(inflater, R.layout.fragment_template, container, false).also {
                binding = it
            }.root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initial()
    }

    private fun initial() {
        templateFragmentViewModel = ViewModelProviders.of(this).get(TemplateViewModel::class.java)
    }
}