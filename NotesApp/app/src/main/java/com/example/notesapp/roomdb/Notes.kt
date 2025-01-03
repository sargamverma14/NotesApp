package com.example.notesapp.roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "myNotes")
data class Notes(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "notes_id")
    val id:Int,

    @ColumnInfo(name = "notes_title")
    val title:String,

    @ColumnInfo(name = "notes_des")
    val desc :String,

    @ColumnInfo(name = "notes_date")
    val date :String
)
