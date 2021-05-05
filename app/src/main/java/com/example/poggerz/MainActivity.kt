package com.example.poggerz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noted.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //create list of notes
        var notesList = mutableListOf(
            Note("Note 1", false),
            Note("Note 2", true)
        )

        //adapter
        val adapter = NoteAdapter(notesList)
        rv_notes.adapter = adapter
        rv_notes.layoutManager = LinearLayoutManager(this)

        btn_add.setOnClickListener {
            val title = et_new_note.text.toString()
            val note = Note(title, false)

            notesList.add(note)

            //notify adapter
            adapter.notifyItemInserted(notesList.size - 1)

            et_new_note.text.clear()
        }
    }
}