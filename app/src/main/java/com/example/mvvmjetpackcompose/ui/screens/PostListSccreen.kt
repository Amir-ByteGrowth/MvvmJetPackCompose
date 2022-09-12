package com.example.mvvmjetpackcompose.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.mvvmjetpackcompose.data.models.PostsResponseItem
import com.example.mvvmjetpackcompose.ui.screens.components.CreatePostItem

@Composable
fun CreatePostsListScreen(list: List<PostsResponseItem>) {
    LazyColumn {
        itemsIndexed(list) { index, item -> CreatePostItem(postsResponseItem = item) }
    }
}

@Preview
@Composable
fun PreviewPostsListScreen() {

}