package com.example.hellojetpackcompose

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Item(var dist: String, var icon: ImageVector) {
    object Home : Item("Home", Icons.Filled.Home)
    object Search : Item("Search", Icons.Filled.Search)
    object Notifications : Item("Notifications", Icons.Filled.Notifications)
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