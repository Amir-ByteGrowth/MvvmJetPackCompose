package com.example.mvvmjetpackcompose.roomscreen

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.protobuf.Empty
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mvvmjetpackcompose.data.models.Note
import com.example.mvvmjetpackcompose.roomscreen.components.RoomScreenViewModel
import com.example.mvvmjetpackcompose.roomscreen.components.screens.CreateNoteItem
import com.example.mvvmjetpackcompose.roomscreen.components.screens.CreateNotesScreen
import com.example.mvvmjetpackcompose.roomscreen.components.screens.addnotes.CreateAddNoteScreen
import com.example.mvvmjetpackcompose.roomscreen.ui.theme.MvvmJetPackComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoomScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MvvmJetPackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    Greeting2("Android")
                    CreateNotes()
                }
            }
        }
    }
}


@Composable
fun CreateNotes(
    roomScreenViewModel: RoomScreenViewModel = hiltViewModel(), modifier: Modifier = Modifier
) {

    var notes = roomScreenViewModel.notesList
    Log.d("NotesListIGot",notes.toString())
    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.White)
    ) {


        var addNoteScreen by remember { mutableStateOf(false) }

        if (addNoteScreen) {
            CreateAddNoteScreen(
                roomScreenViewModel = roomScreenViewModel,
                onItemClick = {
                    Log.d("NoteItem", it.noteDescription.toString())
                    roomScreenViewModel.insertNote(it)
                    addNoteScreen = false
//                    roomScreenViewModel.getAllNotes()
                })
        } else {
            CreateNotesScreen(notes = notes,roomScreenViewModel)
        }

        FloatingActionButton(
            modifier = Modifier
                .padding(all = 16.dp)
                .align(alignment = Alignment.BottomEnd),
            onClick = {

                addNoteScreen = true
            }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
        }
    }

}


@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    MvvmJetPackComposeTheme {
        Greeting2("Android")
    }
}