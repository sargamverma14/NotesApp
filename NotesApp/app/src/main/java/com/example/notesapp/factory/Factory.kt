package com.example.notesapp.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notesapp.repository.repo
import com.example.notesapp.viewmodel.MainActivityViewModel

class Factory(val context : Context, val myrepo: repo):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainActivityViewModel::class.java))
        {
            return MainActivityViewModel(context, myrepo) as T
        }
        throw IllegalArgumentException("class not found!!")
    }
}