package com.darkkillen.kotlinaac.template.activity

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.darkkillen.kotlinaac.MainApplication
import com.darkkillen.kotlinaac.R
import com.darkkillen.kotlinaac.databinding.ActivityTemplateBinding
import com.darkkillen.kotlinaac.template.viewmodel.TemplateViewModel
import com.darkkillen.kotlinaac.ui.activity.base.BaseActivity

/**
 * Created by darkkillen on 9/1/2017 AD.
 */
class TemplateActivity : BaseActivity() {

    private val viewModel: TemplateViewModel by lazy {
        ViewModelProviders.of(this).get(TemplateViewModel::class.java).also {
            MainApplication.component.inject(it)
        }
    }

    private lateinit var binding: ActivityTemplateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initial()
    }

    private fun initial() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_template)

    }

}