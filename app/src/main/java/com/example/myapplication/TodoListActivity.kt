package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class TodoListActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userInfo = intent.extras?.getString("username")
        setContentView(R.layout.todo_list)
        todoAdapter = TodoAdapter(mutableListOf())
        val recyclerView: RecyclerView = findViewById(R.id.rvTodoItems)
        recyclerView.adapter = todoAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        val btnAddTodo: Button = findViewById(R.id.btnAddTodo)
        val todoText: TextView = findViewById(R.id.helloText)
        todoText.text = buildString {
        append("Hello ")
        append(userInfo)
    }

        btnAddTodo.setOnClickListener {
            val etTodoTitle: TextView = findViewById(R.id.etTodoTitle)
            val todoTitle = etTodoTitle.text.toString()
            if (todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                etTodoTitle.text = "";
                todoText.text = todoTitle

            }
        }
        val btnDeleteDoneTodos: Button = findViewById(R.id.btnDeleteDoneTodos)
        btnDeleteDoneTodos.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}