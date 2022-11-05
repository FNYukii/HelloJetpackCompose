package com.example.hellojetpackcompose

import android.annotation.SuppressLint
import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@SuppressLint("MutableCollectionMutableState")
@Composable
fun FirstScreen() {

    var todos by remember { mutableStateOf(ArrayList<String>()) }

    val db = Firebase.firestore
    db.collection("todos")
        .addSnapshotListener { value, e ->
            if (e != null) {
                Log.w(ContentValues.TAG, "Listen failed.", e)
                return@addSnapshotListener
            }

            val newTodos = ArrayList<String>()
            for (doc in value!!) {
                doc.getString("text")?.let {
                    newTodos.add(it)
                }
            }

            todos = newTodos
        }

    LazyColumn {

        items(items = todos) { name ->

            Text(text = name)
        }
    }


}