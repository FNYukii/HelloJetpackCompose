package com.example.hellojetpackcompose.ui.todo_editor

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val todoEditorRoute = "/todo-editor"
fun NavGraphBuilder.todoEditorNavGraph(onNavigateUp: () -> Unit) {
    composable(todoEditorRoute) {
        TodoEditorScreen()
    }
}

@Composable
fun TodoEditorScreen(
    todosViewModel: TodoEditorViewModel = hiltViewModel()
) {
    Text("Todo Editor")
}