package com.example.poggerz.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.poggerz.ChatActivity
import com.example.poggerz.R
import kotlinx.android.synthetic.main.fragment_groups.*

class GroupsFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_groups, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_group_one.setOnClickListener {
            Log.d("Test Button", "Button one clicked")
            val intent = Intent (getActivity(), ChatActivity::class.java)
            intent.putExtra("chatId", "lore")
            requireActivity().startActivity(intent)

        }

    }



}


