package com.example.hellojetpackcompose.ui.todo_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.hellojetpackcompose.ui.todo_editor.todoEditorRoute

@Composable
fun TodoListScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    todosViewModel: TodoListViewModel = hiltViewModel()
) {

    val todos by todosViewModel.todos.collectAsState()
    todosViewModel.load()

    Column {

        Button(
            onClick = {
                navController.navigate(todoEditorRoute)
            },
        ) {
            Text("Click")
        }

        LazyColumn {
            items(items = todos) { todo ->

                Column {
                    Text(text = todo.text, Modifier.padding(16.dp))
                    Divider()
                }
            }
        }
    }
}