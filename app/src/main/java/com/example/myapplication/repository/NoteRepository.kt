package com.example.myapplication.repository

import com.example.myapplication.Note
import com.example.myapplication.NoteDao
import com.example.myapplication.data.remote.NoteApi
import kotlinx.coroutines.flow.Flow

class NoteRepository(
    private val noteDao: NoteDao,
    private val api: NoteApi
) {
    val notes: Flow<List<Note>> = noteDao.getAllNotes()

    suspend fun syncNotes() {
        val remoteNotes = api.getNotes()
        remoteNotes.forEach { noteDao.insertNote(it) }
    }

    suspend fun addNote(note: Note) {
        noteDao.insertNote(note)
        api.postNote(note)
    }

    suspend fun deleteNoteById(id: Int) {
        noteDao.deleteNoteById(id)
        api.deleteNoteById(id)
    }
}