package com.example.notesapp.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.repository.repo
import com.example.notesapp.roomdb.Notes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel(val context: Context, private val myrepo: repo) : ViewModel() {
    val getData : LiveData<List<Notes>> = myrepo.getAll

    fun insertNote(title: String, desc: String, date: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val row: Long = myrepo.insert(Notes(0, title, desc, date))
            withContext(Dispatchers.Main) {
                if (row > 0) {
                    Toast.makeText(context, "Saved!!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Not Saved!!", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }
}




