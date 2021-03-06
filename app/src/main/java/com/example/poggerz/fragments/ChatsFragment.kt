package com.example.poggerz.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.poggerz.ChatActivity
import com.example.poggerz.R
import com.example.poggerz.utils.Constants
import kotlinx.android.synthetic.main.fragment_groups.*
import kotlinx.android.synthetic.main.fragment_individuals.*
import kotlinx.android.synthetic.main.fragment_individuals.btn_one

class ChatsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view: View = inflater!!.inflate(R.layout.fragment_groups, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_group_one.setOnClickListener {
            Log.d("Test Button", "Button one clicked")
            val intent = Intent (getActivity(), ChatActivity::class.java)
            intent.putExtra("chatId", "lore")
            requireActivity().startActivity(intent)

        }

        btn_group_two.setOnClickListener {
            Log.d("Test Button", "Button one clicked")
            val intent = Intent (getActivity(), ChatActivity::class.java)
            intent.putExtra("chatId", "characters")
            requireActivity().startActivity(intent)

        }

        btn_group_three.setOnClickListener {
            Log.d("Test Button", "Button one clicked")
            val intent = Intent (getActivity(), ChatActivity::class.java)
            intent.putExtra("chatId", "phases")
            requireActivity().startActivity(intent)

        }

        btn_group_four.setOnClickListener {
            Log.d("Test Button", "Button one clicked")
            val intent = Intent (getActivity(), ChatActivity::class.java)
            intent.putExtra("chatId", "music_style")
            requireActivity().startActivity(intent)

        }

    }



}