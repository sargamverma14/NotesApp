package com.example.notesapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notesapp.adaptor.Adaptor
import com.example.notesapp.databinding.ActivityMainBinding
import com.example.notesapp.factory.Factory
import com.example.notesapp.repository.repo
import com.example.notesapp.roomdb.Notes
import com.example.notesapp.roomdb.NotesDataBase
import com.example.notesapp.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity(), Adaptor.OnItemClickListener {
    lateinit var binding: ActivityMainBinding
    lateinit var myviewModel: MainActivityViewModel
    lateinit var factory: Factory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dao = NotesDataBase.getInstance(this)!!.dao
        val myrepo = repo(dao)
        factory = Factory(this, myrepo)
        myviewModel = ViewModelProvider(this, factory)[MainActivityViewModel::class.java]
        binding.btnFloat.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        binding.rv.layoutManager = LinearLayoutManager(this)

        myviewModel.getData.observe(this, Observer {
            val adaptor = Adaptor(this, it, this)
            binding.rv.adapter = adaptor
            binding.lifecycleOwner = this

        })


    }

    override fun onResume() {
        super.onResume()
        myviewModel.getData.observe(this, Observer {
            val adaptor = Adaptor(this, it, this)
            binding.rv.adapter = adaptor
            binding.lifecycleOwner = this

        })
    }

    override fun click(position: Int, notes: Notes) {
        TODO("Not yet implemented")
    }

    override fun onItemClick(position: Int, notes: Notes) {
        TODO("Not yet implemented")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.search -> {

            }

            R.id.delete -> {

            }

        }
        return onOptionsItemSelected(item)
    }
}
