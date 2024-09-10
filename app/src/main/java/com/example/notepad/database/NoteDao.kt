package com.example.notepad.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.notepad.model.Notes

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note:Notes)

    @Update
    suspend fun updateNotes(note: Notes)

    @Delete
    suspend fun deleteNote(note: Notes)

    @Query("SELECT * FROM notes ORDER BY id DESC")
    fun getAllNotes():LiveData<List<Notes>>

    @Query("SELECT * FROM notes WHERE noteTitle LIKE :query OR noteDescription LIKE :query")
    fun searchNotes(query:String?):LiveData<List<Notes>>

}