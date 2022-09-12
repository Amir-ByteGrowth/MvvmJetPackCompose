package com.example.mvvmjetpackcompose.baseclasses

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity



open class BaseActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)


    }


}