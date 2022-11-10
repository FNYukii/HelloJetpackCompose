package com.example.hellojetpackcompose.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.hellojetpackcompose.ui.todo_creation.TodoCreationScreen
import com.example.hellojetpackcompose.ui.todo_editor.todoEditorNavGraph
import com.example.hellojetpackcompose.ui.todo_list.TodoListScreen

@Composable
fun App() {
    val navController = rememberNavController()

    Scaffold(

        Modifier.fillMaxSize(),
        bottomBar = {
            BottomNav(navController = navController)
        },
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = Routes.TopLevel.TodoList.route
        ) {
            composable(Routes.TopLevel.TodoList.route) {
                TodoListScreen(navController, Modifier.padding(paddingValues))
            }

            composable(Routes.TopLevel.TodoCreation.route) {
                TodoCreationScreen()
            }

            todoEditorNavGraph(onNavigateUp = {
                navController.popBackStack()
            })
        }
    }
}

sealed class Routes (
    val route: String
) {

    sealed class TopLevel(
        route: String,
        val label: String,
        val icon: ImageVector,
    ) : Routes(route = route) {

        object TodoList : TopLevel(
            label = "Todos",
            icon = Icons.Default.List,
            route = "/todo-list"
        )
        object TodoCreation : TopLevel(
            label = "Create",
            icon = Icons.Default.Add,
            route = "/todo-creation"
        )
    }
}

val items = listOf(
    Routes.TopLevel.TodoList,
    Routes.TopLevel.TodoCreation
)

@Composable
private fun BottomNav(navController: NavController) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.surface,
    ) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        items.forEach { screen ->

            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                label = {
                    Text(screen.label)
                },
                icon = {
                    Icon(screen.icon, null)
                },
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.medium)
            )
        }
    }
}
