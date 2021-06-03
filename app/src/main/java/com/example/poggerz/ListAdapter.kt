package com.example.poggerz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.poggerz.fragments.PeopleFragment
import com.example.poggerz.model.Item
import kotlinx.android.synthetic.main.item_person.view.*


class ListAdapter(private val itemList: List<Item>,
                  private val activity: MainActivity
) : RecyclerView.Adapter<ListAdapter.ListViewHolder>(){

    //inner class to handel our item holder
    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val labelView: TextView = itemView.tv_label


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent,false)

        return ListViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentItem = itemList[position]

        holder.labelView.text = currentItem.label

        holder.labelView.setOnClickListener{
            Toast.makeText(activity, "Id selected: ${currentItem}", Toast.LENGTH_SHORT).show()
        }
    }
}