package com.example.poggerz.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.poggerz.ChatActivity
import kotlinx.android.synthetic.main.fragment_individuals.*
import kotlinx.android.synthetic.main.fragment_individuals.view.*

class IndividualsFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_one.setOnClickListener {
            activity?.let {
                val intent = Intent(it, ChatActivity::class.java)
                it.startActivity(intent)
            }

        }
    }
}