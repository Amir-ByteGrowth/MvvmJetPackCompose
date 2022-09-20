package com.example.mvvmjetpackcompose.roomscreen.components.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvvmjetpackcompose.R
import com.example.mvvmjetpackcompose.data.models.Note

@Composable
fun CreateNoteItem(note: Note, onItemClick: () -> Unit, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp), color = Color.DarkGray, shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = modifier.padding(vertical = 15.dp, horizontal = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = note.noteTitle,
                    style = MaterialTheme.typography.h6.copy(color = Color.White)
                )
                Spacer(modifier = modifier.height(10.dp))
                Text(
                    text = "Last Updated: ${note.timestamp}",
                    style = MaterialTheme.typography.h6.copy(color = Color.White, fontSize = 13.sp)
                )
            }
            IconButton(onClick = onItemClick) {
                Icon(
                    Icons.Filled.Delete,
                    contentDescription = "Localized description",
                    tint = Color.White,

                    )
            }

        }
    }
}

@Preview
@Composable
fun PreviewNoteItem() {
    CreateNoteItem(
        Note(
            id = 1,
            noteTitle = "Title",
            noteDescription = "Here descrtiption",
            timestamp = "tiiasdnasjdasnn"
        ), {})
}