package com.example.hellojetpackcompose.ui.todo_list

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.hellojetpackcompose.entities.Todo
import com.example.hellojetpackcompose.utilities.toTodo
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor() : ViewModel() {

    private val _todos = MutableStateFlow(ArrayList<Todo>())
    val todos = _todos.asStateFlow()

    fun load() {
        val db = Firebase.firestore
        db.collection("todos")
            .addSnapshotListener { value, e ->
                if (e != null) {
                    Log.w(ContentValues.TAG, "Listen failed.", e)
                    return@addSnapshotListener
                }

                val newTodos = ArrayList<Todo>()
                for (doc in value!!) {

                    val todo = doc.toTodo()
                    newTodos.add(todo)
                }

                _todos.value = newTodos
            }
    }

    fun createTodo(text: String) {

        val data = hashMapOf(
            "text" to text,
        )

        val db = Firebase.firestore
        db.collection("todos")
            .add(data)
            .addOnSuccessListener { documentReference ->
                Log.d(ContentValues.TAG, "DocumentSnapshot written with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(ContentValues.TAG, "Error adding document", e)
            }
    }
}
