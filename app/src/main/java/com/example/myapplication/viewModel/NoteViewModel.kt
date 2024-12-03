package com.example.myapplication.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.Note
import com.example.myapplication.repository.NoteRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class NoteViewModel(
    private val repository: NoteRepository
) : ViewModel() {
    val notes: StateFlow<List<Note>> = repository.notes.stateIn(
        scope = viewModelScope,
        started = kotlinx.coroutines.flow.SharingStarted.Lazily,
        initialValue = emptyList()
    )

    fun addNote(title: String, content: String) {
        viewModelScope.launch {
            repository.addNote(Note(title = title, content = content, isSynced = false))
        }
    }

    fun deleteNoteById(id: Int) {
        viewModelScope.launch {
            repository.deleteNoteById(id)
        }
    }

    fun syncNotes() {
        viewModelScope.launch {
            repository.syncNotes()
        }
    }
}