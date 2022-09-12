package com.example.mvvmjetpackcompose.ui.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvvmjetpackcompose.data.models.PostsResponseItem

@Composable
fun CreatePostItem(modifier: Modifier = Modifier, postsResponseItem: PostsResponseItem) {
    Column(
        modifier = modifier
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .fillMaxWidth()
    ) {
        Button(onClick = { /*TODO*/ }, modifier = modifier.align(Alignment.End)) {
            Text(text = "Favorite")
        }

        Row(modifier = modifier.padding(vertical = 5.dp), verticalAlignment = CenterVertically) {
            Text(
                text = "UserId: ",
                style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold, fontSize = 15.sp)
            )
            Text(
                text = postsResponseItem.id.toString(),
            )
        }
        Row(modifier = modifier.padding(vertical = 5.dp), verticalAlignment = CenterVertically) {
            Text(
                text = "PostId: ",
                style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold, fontSize = 15.sp)
            )
            Text(
                text = postsResponseItem.userId.toString(),

                )
        }
        Row(modifier = modifier.padding(vertical = 5.dp), verticalAlignment = CenterVertically) {
            Text(
                text = "Title: ",
                style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold, fontSize = 15.sp)
            )
            Text(
                text = postsResponseItem.title,

                )
        }
        Row(modifier = modifier.padding(vertical = 5.dp), verticalAlignment = CenterVertically) {
            Text(
                text = "Body: ",
                style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold, fontSize = 15.sp)
            )
            Text(
                text = postsResponseItem.body,
            )
        }

        Divider()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPostItem() {
    CreatePostItem(postsResponseItem = PostsResponseItem("here is body", 1, "Title", 1))
}