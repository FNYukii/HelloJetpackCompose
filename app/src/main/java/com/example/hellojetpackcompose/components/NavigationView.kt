package com.example.hellojetpackcompose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.hellojetpackcompose.screens.FirstScreen
import com.example.hellojetpackcompose.SecondScreen
import com.example.hellojetpackcompose.ThirdScreen

@Composable
fun NavigationView() {

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

@Composable
fun BottomNavigationBar(onClick: (selection: Int) -> Unit) {

    val selectedItem = remember { mutableStateOf(0) }
    val items = listOf(Item.Home, Item.Search, Item.Notifications)

    BottomNavigation {
        items.forEachIndexed { index, item ->

            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = item.dist) },
                label = { Text(item.dist) },
                selected = selectedItem.value == index,
                onClick = {
                    selectedItem.value = index
                    onClick(index)
                }
            )
        }
    }
}

sealed class Item(var dist: String, var icon: ImageVector) {
    object Home : Item("Home", Icons.Filled.Home)
    object Search : Item("Search", Icons.Filled.Search)
    object Notifications : Item("Notifications", Icons.Filled.Notifications)
}