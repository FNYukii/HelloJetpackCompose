package com.example.hellojetpackcompose.utilities

import com.example.hellojetpackcompose.entities.Todo
import com.google.firebase.firestore.QueryDocumentSnapshot

class FireTodos {

    companion object {

        fun toTodo(document: QueryDocumentSnapshot): Todo {
            val id: String = document.id
            val text: String = document.data["text"] as String

            return Todo(id, text)
        }
    }
}