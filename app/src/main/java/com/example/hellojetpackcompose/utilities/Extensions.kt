package com.example.hellojetpackcompose.utilities

import com.example.hellojetpackcompose.entities.Todo
import com.google.firebase.firestore.QueryDocumentSnapshot

fun QueryDocumentSnapshot.toTodo(): Todo {
    val id: String = this.id
    val text: String = this.data["text"] as String

    return Todo(id, text)
}