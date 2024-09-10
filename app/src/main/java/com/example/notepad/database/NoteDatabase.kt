package com.example.notepad.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notepad.model.Notes

@Database(entities = [Notes::class], version = 1)
abstract class NoteDatabase: RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    companion object{

        @Volatile
        private var instance: NoteDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: android.content.Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: android.content.Context) = androidx.room.Room.databaseBuilder(
            context.applicationContext,
            NoteDatabase::class.java,
            "note_database"
        ).build()
    }
}