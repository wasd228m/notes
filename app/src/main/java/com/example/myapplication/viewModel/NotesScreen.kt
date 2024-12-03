package com.example.myapplication.viewModel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState


@Composable
fun NotesScreen(viewModel: NoteViewModel) {
    val notes by viewModel.notes.collectAsState()

    Column {
        LazyColumn {
            items(notes) { note ->
                NoteItem(note = note)
            }
        }
        Button(onClick = { viewModel.syncNotes() }) {
            Text("Синхронизировать")
        }
    }
}