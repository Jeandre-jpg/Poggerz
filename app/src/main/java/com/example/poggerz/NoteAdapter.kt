package com.example.poggerz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noted.R
import kotlinx.android.synthetic.main.item_note.view.*


class NoteAdapter(
    var notes: List<Note>
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    //identify the item that needs to be reused
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    //return amount of notes in list
    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        holder.itemView.apply{
            tv_title.text = notes[position].title
            cb_done.isChecked = notes[position].isChecked
        }
    }

}