package com.example.mvvmjetpackcompose.data.local.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvmjetpackcompose.data.models.Note
import com.example.mvvmjetpackcompose.data.models.PostsResponseItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

@Singleton
@Dao
interface AppDao {

    // to insert data
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note):Long

    // to delete data
    @Delete
    fun delete(note: Note)

    // to update data
    @Update
    fun update(note: Note)

    // to read the data (all the data)
    @Query("Select * from notesTable")
    fun getAllNotes(): Flow<List<Note>>



}