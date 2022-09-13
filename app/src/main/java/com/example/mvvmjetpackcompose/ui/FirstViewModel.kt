package com.example.mvvmjetpackcompose.ui

//import androidx.hilt.lifecycle.ViewModelInject
import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmjetpackcompose.data.models.PostsResponse
import com.example.mvvmjetpackcompose.data.models.PostsResponseItem
import com.example.mvvmjetpackcompose.data.remote.Resource
import com.example.mvvmjetpackcompose.data.remote.ResourceSealed
import com.example.mvvmjetpackcompose.data.remote.reporitory.MainRepository
import com.example.mvvmjetpackcompose.utils.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {


    private val _posts = MutableStateFlow<ResourceSealed<PostsResponse>>(ResourceSealed.Empty())
    val postsData: StateFlow<ResourceSealed<PostsResponse>>
        get() = _posts


    private val _userName = MutableStateFlow("")
    val userName: StateFlow<String>
        get() = _userName

    init {
        fetchPostsFromApi()
        getUserName()
    }

    fun fetchPostsFromApi() {
        viewModelScope.launch {
            _posts.value = ResourceSealed.Loading()
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getPosts().let {
                    if (it.isSuccessful) {
                        Log.d("DataFetched", it.body().toString())
                        _posts.value = ResourceSealed.Success(it.body()!!)
                    } else _posts.value = ResourceSealed.Error(it.message(), null)
                }
            } else _posts.value = ResourceSealed.Error("No internet connection", null)
        }
    }

    var usrName= mainRepository.getName
    fun getUserName() {
        viewModelScope.launch {
            mainRepository.getName.collectLatest {
                _userName.value = it
            }
        }

    }

    fun setUserName(name:String){
        viewModelScope.launch {
            mainRepository.setName(false,name)
        }

    }


}
