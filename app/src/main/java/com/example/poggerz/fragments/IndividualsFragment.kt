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
import kotlinx.android.synthetic.main.fragment_individuals.*
import kotlinx.android.synthetic.main.fragment_individuals.view.*

class IndividualsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val view: View = inflater!!.inflate(R.layout.fragment_individuals, container, false)

//      btn_one.setOnClickListener { view ->
//            Log.d("btnSetup", "Selected")
//        }

        // Return the fragment view/layout
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_one.setOnClickListener {
            Log.d("Test Button", "Button one clicked")
            activity?.let {
                val intent = Intent(it, ChatActivity::class.java)
                it.startActivity(intent)
            }

        }

        btn_two.setOnClickListener {
            activity?.let {
                val intent = Intent(it, ChatActivity::class.java)
                it.startActivity(intent)
            }

        }

        btn_three.setOnClickListener {
            activity?.let {
                val intent = Intent(it, ChatActivity::class.java)
                it.startActivity(intent)
            }

        }

        btn_four.setOnClickListener {
            activity?.let {
                val intent = Intent(it, ChatActivity::class.java)
                it.startActivity(intent)
            }

        }

        btn_five.setOnClickListener {
            activity?.let {
                val intent = Intent(it, ChatActivity::class.java)
                it.startActivity(intent)
            }

        }
    }
}