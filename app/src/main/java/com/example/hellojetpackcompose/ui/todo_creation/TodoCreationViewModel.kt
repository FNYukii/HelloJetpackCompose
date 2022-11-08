package com.example.hellojetpackcompose.ui.todo_creation

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodoCreationViewModel @Inject constructor() : ViewModel() {

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