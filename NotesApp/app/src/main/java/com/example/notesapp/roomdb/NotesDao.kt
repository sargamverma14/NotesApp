package com.example.notesapp.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NotesDao {
    @Insert
    suspend fun insert(notes: Notes):Long

    @Delete
    suspend fun delete(notes: Notes):Int

    @Update
    suspend fun update(notes: Notes):Int

    @Query("DELETE FROM myNotes")
    suspend fun deleteAll():Int

    @Query("SELECT * FROM mynotes")
    fun getAll(): LiveData<List<Notes>>
}