package com.example.mvvmjetpackcompose.data.remote


import com.example.mvvmjetpackcompose.data.models.PostsResponse
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface ApiService {

    @GET("posts")
    suspend fun getPosts(): Response<PostsResponse>
}