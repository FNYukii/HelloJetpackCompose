package com.example.hellojetpackcompose.screens

import android.annotation.SuppressLint
import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import com.example.hellojetpackcompose.entities.Todo
import com.example.hellojetpackcompose.utilities.FireTodos
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@SuppressLint("MutableCollectionMutableState")
@Composable
fun FirstScreen() {

    var todos by remember { mutableStateOf(ArrayList<Todo>()) }

    val db = Firebase.firestore
    db.collection("todos")
        .addSnapshotListener { value, e ->
            if (e != null) {
                Log.w(ContentValues.TAG, "Listen failed.", e)
                return@addSnapshotListener
            }

            val newTodos = ArrayList<Todo>()
            for (doc in value!!) {

                val todo = FireTodos.toTodo(doc)
                newTodos.add(todo)
            }

            todos = newTodos
        }

    LazyColumn {

        items(items = todos) { todo ->

            Text(text = todo.text)
        }
    }
}