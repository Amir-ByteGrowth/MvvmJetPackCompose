package com.example.mvvmjetpackcompose.data.remote.reporitory

import com.example.mvvmjetpackcompose.data.local.db.AppDao
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


}