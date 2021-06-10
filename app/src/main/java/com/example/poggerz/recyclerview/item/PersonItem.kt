package com.example.poggerz.recyclerview.item

import android.content.Context
import com.example.poggerz.R
import com.example.poggerz.model.User
import com.example.poggerz.utils.StorageUtil
import com.resocoder.firemessage.glide.GlideApp
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.fragment_profile.view.*
import kotlinx.android.synthetic.main.item_person.*
import kotlinx.android.synthetic.main.item_person.view.*
import kotlinx.android.synthetic.main.nav_header.*

//class PersonItem(
//    val person: User,
//    val userId: String,
//    private val context: Context)
//    : Item(){}

//    override fun bind(viewHolder: GroupieViewHolder, position: Int) {

//        viewHolder.itemView.apply {
//            et_name.text = person.name
//            et_email.text = person.email
//            if (person.profileImagePath != null)
//                GlideApp.with(context)
//                    .load(StorageUtil.pathToReference(person.profileImagePath))
//                    .placeholder(R.drawable.user_profile)
//                    .into(viewHolder.profile_image_user)
//        }
//    }

//    override fun getLayout() = R.layout.item_person
//}