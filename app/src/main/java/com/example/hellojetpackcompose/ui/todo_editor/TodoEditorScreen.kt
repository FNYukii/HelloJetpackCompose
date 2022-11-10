package com.example.hellojetpackcompose.ui.todo_editor

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TodoEditorScreen(
    todosViewModel: TodoEditorViewModel = hiltViewModel()
) {
    Text("Todo Editor")
}