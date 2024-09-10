package com.example.notepad.repository

import androidx.room.Query
import com.example.notepad.database.NoteDatabase
import com.example.notepad.model.Notes

class NoteRepository(private val db: NoteDatabase) {

    suspend fun insertNote(note: Notes) = db.getNoteDao().insertNote(note)
    suspend fun updateNote(note: Notes) = db.getNoteDao().updateNotes(note)
    suspend fun deleteNote(note: Notes) = db.getNoteDao().deleteNote(note)

    fun getAllNotes()=db.getNoteDao().getAllNotes()
    fun searchNotes(query: String?)=db.getNoteDao().searchNotes(query)

}