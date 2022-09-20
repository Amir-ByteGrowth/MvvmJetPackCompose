package com.example.mvvmjetpackcompose.roomscreen.components

import android.util.Log
import android.util.Log.d
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmjetpackcompose.data.models.Note
import com.example.mvvmjetpackcompose.data.models.PostsResponse
import com.example.mvvmjetpackcompose.data.remote.ResourceSealed
import com.example.mvvmjetpackcompose.data.remote.reporitory.MainRepository
import com.example.mvvmjetpackcompose.utils.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.logging.Logger
import javax.inject.Inject

@HiltViewModel
class RoomScreenViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {
    // variable creation
//    val allNotes: LiveData<List<Note>>

    var _notes = MutableStateFlow<List<Note>>(listOf())
//    val notesList: StateFlow<List<Note>>
//        get() = _notes

    var notesList by mutableStateOf(emptyList<Note>())

    // initializations
    init {

//        viewModelScope.launch {
//            mainRepository.allNotes.value.let {
//                if (it.isNullOrEmpty()) {
//                    Log.d("NoteListEmpty", "True"+it.toString())
//                    _notes.value= listOf()
//                } else {
//                    Log.d("NoteListEmpty", "false")
//                    _notes.value = it
//                }
//            }
//        }

        getAllNotes()
    }

    fun getAllNotes() {
        viewModelScope.launch {

            mainRepository.allNotes().collect {notes ->
                notesList = notes
            }
//            var notesList = mainRepository.allNotes()
            Log.d("NotesList", notesList.toString())
//            if (notesList.isNullOrEmpty()) {
//                _notes.value = listOf()
//            } else {
//                _notes.value = notesList
//            }
        }

    }

    fun delNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        mainRepository.delete(note)
    }

    fun updNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        mainRepository.update(note)
    }

    fun insertNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        val addedID = mainRepository.insert(note)
        Log.d("vehicle_lsit_item", "Inserted ID $addedID")
    }


}