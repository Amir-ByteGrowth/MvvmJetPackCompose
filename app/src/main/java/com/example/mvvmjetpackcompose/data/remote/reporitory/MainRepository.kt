package com.example.mvvmjetpackcompose.data.remote.reporitory

import com.example.mvvmjetpackcompose.data.local.datastore.DataStoreProvider
import com.example.mvvmjetpackcompose.data.local.db.AppDao
import com.example.mvvmjetpackcompose.data.models.PostsResponseItem
import com.example.mvvmjetpackcompose.data.remote.ApiService
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MainRepository @Inject constructor(
    private val apiService: ApiService,
    private val localDataSource: AppDao,
    private val dataStoreProvider: DataStoreProvider
) {

    suspend fun getPosts() = apiService.getPosts()

    val getName = dataStoreProvider.userNameFlow

    suspend fun setName(islocalization: Boolean, name: String) =
        dataStoreProvider.storeData(islocalization, name)

}