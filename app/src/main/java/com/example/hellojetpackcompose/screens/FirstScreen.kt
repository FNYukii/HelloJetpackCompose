package com.example.hellojetpackcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FirstScreen() {

    Column(modifier = Modifier.padding(8.dp)) {

        LazyColumn {

            val fruits: List<String> = listOf("Apple", "Orange", "Banana", "Melon", "Berry")

            items(items = fruits) { name ->

                Text(text = name)
            }
        }

        Button(
            onClick = {}
        ) {
            Text("Click")
        }

    }
}