package com.example.hellojetpackcompose

import android.annotation.SuppressLint
import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.security.Timestamp

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
//                doc.getString("text")?.let {
//                    newTodos.add(it)
//                }

                val todo = FireTodos.toTodo(doc)
                newTodos.add(todo)
            }

            todos = newTodos
        }

    LazyColumn {

        items(items = todos) { todo ->

            Text(text = "${todo.text}")
        }
    }
}

data class Todo(
    val id: String,
    val text: String
)

class FireTodos {

    companion object {

        fun toTodo(document: QueryDocumentSnapshot): Todo {
            val id: String = document.id
            val text: String = document.data.get("text") as String

            return Todo(id, text)
        }
    }
}