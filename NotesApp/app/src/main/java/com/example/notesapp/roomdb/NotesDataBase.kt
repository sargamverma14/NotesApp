package com.example.notesapp.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.util.readVersion

@Database(entities =[Notes::class],version=1)
abstract class NotesDataBase:RoomDatabase() {
    abstract val dao:NotesDao

    companion object{
        @Volatile
        private var INSTANCE:NotesDataBase? = null
        fun getInstance(context: Context): NotesDataBase?{
            var instacne = INSTANCE
            if (instacne == null){
                synchronized(this){
                    instacne = Room.databaseBuilder(context, NotesDataBase::class.java, "subscriber")
                        .build()
                }
                INSTANCE = instacne
            }
            return instacne
        }
    }

}