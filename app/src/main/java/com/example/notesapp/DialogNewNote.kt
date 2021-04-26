package com.example.notesapp

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class DialogNewNote: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(this.activity)

        val inflater = activity?.layoutInflater

        val dialogView = inflater?.inflate(R.layout.dialog_new_note, null)

        val editTitle = dialogView?.findViewById<EditText>(R.id.editTitle)
        val editDescription = dialogView?.findViewById<EditText>(R.id.editDescription)

        val checkBoxIdea = dialogView?.findViewById<CheckBox>(R.id.checkBoxIdea)
        val checkBoxTodo = dialogView?.findViewById<CheckBox>(R.id.checkBoxTodo)
        val checkBoxImportant = dialogView?.findViewById<CheckBox>(R.id.checkBoxImportant)

        val btnCancel = dialogView?.findViewById<Button>(R.id.btnCancel)
        val btnOK = dialogView?.findViewById<Button>(R.id.btnOK)

        builder.setView(dialogView)
        builder.setMessage("Add a new note")

        btnCancel?.setOnClickListener {
            dismiss()
        }

        btnOK?.setOnClickListener {
            val newNote = Note()

            newNote.title = editTitle?.text.toString()
            newNote.description = editDescription?.text.toString()

            newNote.idea = checkBoxIdea?.isChecked == true
            newNote.todo = checkBoxTodo?.isChecked == true
            newNote.important = checkBoxImportant?.isChecked == true

            val callingActivity = activity as MainActivity?
            callingActivity?.createNewNote(newNote)
            dismiss()
        }

        return builder.create()
    }



}