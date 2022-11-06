package com.example.hellojetpackcompose.viewModels

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.hellojetpackcompose.entities.Todo
import com.example.hellojetpackcompose.utilities.FireTodos
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class TodosViewModel @Inject constructor() : ViewModel() {

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

                    val todo = FireTodos.toTodo(doc)
                    newTodos.add(todo)
                }

                _todos.value = newTodos
            }
    }
}
