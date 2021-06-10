package com.example.poggerz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.poggerz.model.Chats
import kotlinx.android.synthetic.main.item_note.view.*
import java.text.DateFormat


class MessagesAdapter(
    var messages: MutableList<Chats>
) : RecyclerView.Adapter<MessagesAdapter.NoteViewHolder>() {

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)



    //identify the item that needs to be reused
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    //return amount of notes in list
    override fun getItemCount(): Int {
        return messages.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        holder.itemView.apply{
            message_contents.text = messages[position].message
            sender.text = messages[position].sender
            message_time.text = messages[position].timestamp.toString()

        }
    }

}