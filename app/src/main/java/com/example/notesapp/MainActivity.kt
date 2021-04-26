package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private var tempNote = Note()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val temp_button = findViewById<Button>(R.id.temp_button)

        temp_button.setOnClickListener {
            val dialog = DialogNewNote()

            dialog.show(supportFragmentManager, "123")
        }
    }

    fun createNewNote(n: Note) {

    }
}