package com.example.mvvmjetpackcompose.roomscreen.components.screens.addnotes

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mvvmjetpackcompose.data.models.Note
import com.example.mvvmjetpackcompose.roomscreen.components.RoomScreenViewModel

@Composable
fun CreateAddNoteScreen(
    modifier: Modifier = Modifier,
    roomScreenViewModel: RoomScreenViewModel?,
    onItemClick: (note: Note) -> Unit
) {

    var title by remember { mutableStateOf("") }
    var detail by remember { mutableStateOf("") }

    Surface(modifier = modifier.padding(horizontal = 20.dp, vertical = 20.dp)) {
        Column(modifier = modifier.fillMaxSize()) {
            TextField(modifier = modifier.fillMaxWidth(),
                value = title,
                onValueChange = { title = it },
                label = { Text(text = "Enter Title") },
                placeholder = { Text(text = "Enter title here") }
            )
            Spacer(modifier = modifier.height(10.dp))

            TextField(
                modifier = modifier.fillMaxWidth(),
                value = detail,
                onValueChange = { detail = it },
                label = { Text(text = "Enter Detail") },
                placeholder = { Text(text = "Enter detail here") }
            )
            Spacer(modifier = modifier.height(30.dp))
            OutlinedButton(
                onClick = {
                    onItemClick(
                        Note(
                            noteTitle = "Not Title",
                            noteDescription = "Note Description",
                            timestamp = "Here is time stamp"
                        )
                    )
                },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
                    .height(40.dp)
            ) {
                Text(text = "Add Note")
            }
        }
    }
}

@Preview
@Composable
fun PreviewAddNoteScreen() {
    CreateAddNoteScreen(roomScreenViewModel = null, onItemClick = { it })
}