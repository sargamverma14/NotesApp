package com.example.notesapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.notesapp.databinding.ActivityMain2Binding
import com.example.notesapp.factory.Factory
import com.example.notesapp.repository.repo
import com.example.notesapp.roomdb.NotesDataBase
import com.example.notesapp.viewmodel.MainActivityViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity2 : AppCompatActivity() {
    lateinit var binding:ActivityMain2Binding
    lateinit var myviewModel:MainActivityViewModel
    lateinit var factory : Factory
    @SuppressLint("SuspiciousIndentation")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =DataBindingUtil.setContentView(this,R.layout.activity_main2)
      val dao = NotesDataBase.getInstance(this)!!.dao
      val myrepo = repo(dao)
        factory = Factory(this,myrepo)
        myviewModel = ViewModelProvider(this,factory)[MainActivityViewModel::class.java]
        binding.btnsave.setOnClickListener{
            val formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY")
            val current = LocalDateTime.now().format(formatter)

            myviewModel.insertNote(binding.mytitle.text.toString(),binding.mydesc.text.toString(),current.toString())
       val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}