package com.example.poggerz.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poggerz.ListAdapter
import com.example.poggerz.MainActivity
import com.example.poggerz.R
import com.example.poggerz.model.Item
import kotlinx.android.synthetic.main.fragment_people.*

class PeopleFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view: View = inflater.inflate(R.layout.fragment_people, container, false)

                val itemList = mutableListOf(
                        Item(1, "First Item"),
                        Item(2, "Second Item"),
                        Item(3, "Third Item"),
                        Item(4, "Fourth Item"),
                        Item(5, "Fifth Item")
                )

                rv_container.adapter = ListAdapter(itemList, MainActivity())
                rv_container.layoutManager = LinearLayoutManager(view.context)
                rv_container.setHasFixedSize(true)
                return view
            }
        }