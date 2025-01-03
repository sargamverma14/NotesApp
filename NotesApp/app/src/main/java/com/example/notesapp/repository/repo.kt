package com.example.notesapp.repository

import androidx.lifecycle.LiveData
import com.example.notesapp.roomdb.Notes
import com.example.notesapp.roomdb.NotesDao
import com.example.notesapp.roomdb.NotesDataBase

class repo (private val dao: NotesDao) {

    suspend fun insert(note: Notes): Long{
        return dao.insert(note)
    }

    suspend fun update(note: Notes): Int{
        return dao.update(note)
    }

    suspend fun delete(note: Notes): Int{
        return dao.delete(note)
    }

    suspend fun deleteAll(): Int{
        return dao.deleteAll()
    }

    var getAll: LiveData<List<Notes>> = dao.getAll()
}
