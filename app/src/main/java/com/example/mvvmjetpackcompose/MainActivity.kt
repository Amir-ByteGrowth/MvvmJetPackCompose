package com.example.mvvmjetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mvvmjetpackcompose.data.models.PostsResponseItem
import com.example.mvvmjetpackcompose.data.remote.ResourceSealed
import com.example.mvvmjetpackcompose.ui.FirstViewModel

import com.example.mvvmjetpackcompose.ui.screens.CreatePostsListScreen
import com.example.mvvmjetpackcompose.ui.theme.MvvmJetPackComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            MvvmJetPackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, viewModel: FirstViewModel = hiltViewModel()) {
//    val firstViewModel: FirstViewModel = hiltViewModel<FirstViewModel>()


    when (val state = viewModel.postsData.collectAsState().value) {
        is ResourceSealed.Empty -> Text(
            text = "Empty",
            modifier = Modifier.padding(16.dp)
        )
        is ResourceSealed.Loading ->
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        is ResourceSealed.Error -> Text(
            text = "Error",
            modifier = Modifier.padding(16.dp)
        )
        is ResourceSealed.Success -> CreatePostsListScreen(list = state.data!!.toList())
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MvvmJetPackComposeTheme {
        Greeting("Android")
    }
}