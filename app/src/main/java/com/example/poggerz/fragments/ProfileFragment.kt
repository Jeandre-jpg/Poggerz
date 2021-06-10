package com.example.poggerz.fragments


import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.poggerz.AuthenticationActivity
import com.example.poggerz.R
import com.example.poggerz.utils.Firestore
import com.example.poggerz.utils.StorageUtil
import com.firebase.ui.auth.AuthUI
import com.resocoder.firemessage.glide.GlideApp
import kotlinx.android.synthetic.main.fragment_profile.*
import java.io.ByteArrayOutputStream

class ProfileFragment : Fragment() {

//    private val RC_SELECT_IMAGE = 2
//    private lateinit var selectedImageBytes: ByteArray
//    private var profileJustChanged = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }



}

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val view = inflater.inflate(R.layout.fragment_profile, container, false)

//            profile_image.setOnClickListener {
//                val intent = Intent().apply {
//                    type = "image/*"
//                    action = Intent.ACTION_GET_CONTENT
//                    putExtra(Intent.EXTRA_MIME_TYPES, arrayOf("image/jpeg", "image/png"))
//                }
//                startActivityForResult(
//                    Intent.createChooser(intent, "Select Image"),
//                    RC_SELECT_IMAGE)
//            }

//            btn_save.setOnClickListener {
//                if (::selectedImageBytes.isInitialized) {
//                    StorageUtil.uploadProfilePhoto(selectedImageBytes) { imagePath ->
//                        Firestore.updateCurrentUser(et_email.text.toString(),
//                            et_name.text.toString(), imagePath)
//                    }
//                } else {
//                    Firestore.updateCurrentUser(et_email.text.toString(),
//                        et_name.text.toString(), null)
//                }
//            }

//            btn_logout.setOnClickListener {
//                AuthUI.getInstance()
//                    .signOut(this@ProfileFragment.context!!)
//                    .addOnCompleteListener {
//                        startActivity(intentFor<AuthenticationActivity>().newTask().clearTask())
//                    }
//            }
//        }
//        return view
//    }
//
//    @RequiresApi(Build.VERSION_CODES.P)
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        if (requestCode == RC_SELECT_IMAGE && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
//            var selectedImagePath = data.data
//            var selectedImageBmp = MediaStore.Images.Media
//                .getBitmap(activity?.contentResolver, selectedImagePath)
//            val outputStream = ByteArrayOutputStream()
//            selectedImageBmp.compress(Bitmap.CompressFormat.JPEG, 90, outputStream)
//            selectedImageBytes = outputStream.toByteArray()
//
//            GlideApp.with(this)
//                .load(selectedImageBytes)
//                .into(profile_image)
//
//            profileJustChanged = true
//        }
//    }
//
//    override fun onStart() {
//        super.onStart()
//        Firestore.getCurrentUser { user ->
//            if (this@ProfileFragment.isVisible) {
//                et_name.setText(user.name)
//                et_email.setText(user.email)
//                if (!profileJustChanged && user.profileImagePath != null) {
//                    GlideApp.with(this)
//                        .load(StorageUtil.pathToReference(user.profileImagePath))
//                        .placeholder(R.drawable.user)
//                        .into(profile_image)
//                }
//            }
//        }
//    }
//}