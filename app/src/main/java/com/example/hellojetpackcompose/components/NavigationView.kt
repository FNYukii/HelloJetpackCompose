package com.example.hellojetpackcompose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.hellojetpackcompose.ui.todo_list.TodoListScreen
import com.example.hellojetpackcompose.ui.todo_creation.TodoCreationScreen

//@Composable
//fun NavigationView() {
//
//    var selection by rememberSaveable { mutableStateOf(0) }
//
//    Column {
//
//        Column(modifier = Modifier.weight(1f)) {
//
//            if (selection == 0) {
//                TodoListScreen()
//            }
//
//            if (selection == 1) {
//                TodoCreationScreen()
//            }
//        }
//
//        BottomNavigationBar(onClick = { selection = it })
//    }
//}
//
//@Composable
//fun BottomNavigationBar(onClick: (selection: Int) -> Unit) {
//
//    val selectedItem = remember { mutableStateOf(0) }
//    val items = listOf(Item.Todos, Item.Create)
//
//    BottomNavigation {
//        items.forEachIndexed { index, item ->
//
//            BottomNavigationItem(
//                icon = { Icon(item.icon, contentDescription = item.dist) },
//                label = { Text(item.dist) },
//                selected = selectedItem.value == index,
//                onClick = {
//                    selectedItem.value = index
//                    onClick(index)
//                }
//            )
//        }
//    }
//}
//
//sealed class Item(var dist: String, var icon: ImageVector) {
//    object Todos : Item("Todos", Icons.Filled.List)
//    object Create : Item("Create", Icons.Filled.Add)
//}