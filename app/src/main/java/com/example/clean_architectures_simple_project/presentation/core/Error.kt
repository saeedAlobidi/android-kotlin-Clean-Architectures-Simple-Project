package com.example.clean_architectures_simple_project.presentation.core

import android.util.Log
import java.lang.Exception

object Error {

    fun set(e: Exception) {
        Log.v("Error--from--saeed-->", e.message.toString())
    }
}