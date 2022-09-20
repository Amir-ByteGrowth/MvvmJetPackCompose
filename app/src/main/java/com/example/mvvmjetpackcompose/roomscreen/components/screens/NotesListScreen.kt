package com.example.mvvmjetpackcompose.roomscreen.components.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import com.example.mvvmjetpackcompose.data.models.Note
import com.example.mvvmjetpackcompose.roomscreen.components.RoomScreenViewModel

@Composable
fun CreateNotesScreen(notes: List<Note>, roomScreenViewModel: RoomScreenViewModel) {
    LazyColumn {
        itemsIndexed(notes) { index, item ->
            CreateNoteItem(
                note = item,
                onItemClick = { roomScreenViewModel.delNote(item) }
            )
        }
    }
}