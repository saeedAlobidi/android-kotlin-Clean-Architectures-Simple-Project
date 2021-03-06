package com.example.clean_architectures_simple_project.presentation.features

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.*
import com.example.clean_architectures_simple_project.Domain.UseCase.getUserAll
import com.example.clean_architectures_simple_project.Domain.UseCase.loadData
import com.example.clean_architectures_simple_project.Gateway.Database.LiveUsers
import com.example.clean_architectures_simple_project.R
import com.example.clean_architectures_simple_project.presentation.core.*

import kotlinx.android.synthetic.main.activity_main.*


//------------------------------------------------------------------------------
// <auto-generated>
//   name :saeed mohammed alabidi
//  Email:saeed1adm@gmail.com
//  Phone:00967-733122038
// </auto-generated>
//------------------------------------------------------------------------------


class MainActivity : BaseCustomActivity() {
    val viewModel by lazy { ViewModelProviders.of(this).get(MainActivityViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
    }


}

class MainActivityViewModel(
    var user: suspend () -> LiveUsers = { getUserAll() }
) : BaseCustomViewModel()

private fun MainActivity.bindViews() = with(viewModel) {


    ViewModelLaunch {

        user.invoke().observe(this@bindViews, Observer { data_txt.text = it.takeIf{ it.isNotEmpty() }?.let {  it.last().title } });

    }


    load_btn.setOnClickListener {

        it.with {  loadData((0..100).random()) }
    }

}

