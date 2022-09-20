package com.example.mvvmjetpackcompose.data.remote.reporitory

import androidx.lifecycle.LiveData
import com.example.mvvmjetpackcompose.data.local.db.AppDao
import com.example.mvvmjetpackcompose.data.models.Note
import com.example.mvvmjetpackcompose.data.models.PostsResponseItem
import com.example.mvvmjetpackcompose.data.remote.ApiService
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MainRepository @Inject constructor(
    private val apiService: ApiService,
    private val localDataSource: AppDao
) {

    suspend fun getPosts() = apiService.getPosts()

    fun allNotes() = localDataSource.getAllNotes()

    // insert
    suspend fun insert(note: Note) = localDataSource.insert(note)

    //delete
    fun delete(note: Note) = localDataSource.delete(note)

    // update
    fun update(note: Note) = localDataSource.update(note)
}