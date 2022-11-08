package com.example.hellojetpackcompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.hellojetpackcompose.viewModels.TodosViewModel

@Composable
fun SecondScreen(
    viewModel: TodosViewModel = hiltViewModel()
) {

    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Todo") },
            modifier = Modifier
                .fillMaxWidth()
        )

        Button(
            onClick = {
                viewModel.createTodo(text)
                text = ""
            },
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
        ) {
            Text("Create")
        }
    }
}


