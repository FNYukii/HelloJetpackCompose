package com.example.hellojetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.example.hellojetpackcompose.ui.theme.HelloJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloJetpackComposeTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun  MyApp() {

    var selection by rememberSaveable { mutableStateOf(0) }

    Column {

        Column(modifier = Modifier.weight(1f)) {

            if (selection == 0) {
                FirstScreen()
            }

            if (selection == 1) {
                SecondScreen()
            }

            if (selection == 2) {
                ThirdScreen()
            }
        }

        BottomNavigationBar(onClick = { selection = it })
    }
}