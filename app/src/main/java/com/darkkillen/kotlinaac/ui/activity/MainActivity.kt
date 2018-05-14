package com.darkkillen.kotlinaac.ui.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.darkkillen.kotlinaac.MainApplication
import com.darkkillen.kotlinaac.R
import com.darkkillen.kotlinaac.data.model.UserModel
import com.darkkillen.kotlinaac.data.model.base.Resource
import com.darkkillen.kotlinaac.data.model.base.Status
import com.darkkillen.kotlinaac.databinding.ActivityMainBinding
import com.darkkillen.kotlinaac.ui.activity.base.BaseActivity
import com.darkkillen.kotlinaac.viewmodel.activity.MainViewModel

/**
 * Created by darkkillen on 9/5/2017 AD.
 */
class MainActivity: BaseActivity() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java).also {
            MainApplication.component.inject(it)
        }
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel.getUser().observe(this, Observer {
            if (it != null) {
                onUserResult(it)
            }
        })

    }

    private fun setUserText(user: UserModel) {
        binding.tvUser.text = user.user
    }

    private fun onUserResult(resource: Resource<UserModel>) {
        when {
            resource.status == Status.SUCCESS -> {
                if (resource.data!=null) {
                    setUserText(resource.data)
                }
            }
            resource.status == Status.ERROR -> {
                Toast.makeText(this, "Something went wrong.", Toast.LENGTH_SHORT).show()
            }
            resource.status == Status.LOADING -> {
                Log.d("debug", "loading...")
            }
        }
    }

}