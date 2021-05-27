package com.example.poggerz.recyclerview.item.ImageMessage

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.poggerz.R
import com.example.poggerz.model.ImageMessage
import com.example.poggerz.util.StorageUtil
import com.example.poggerz.glide.GlideApp
import com.resocoder.firemessage.recyclerview.item.MessageItem


class ImageMessageItem(val message: ImageMessage,
                       val context: Context)
    : MessageItem(message) {

    override fun bind(viewHolder: RecyclerView.ViewHolder, position: Int) {
        super.bind(viewHolder, position)
        GlideApp.with(context)
                .load(StorageUtil.pathToReference(message.imagePath))
                .placeholder(R.drawable.ic_image_black_24dp)
                .into(viewHolder.imageView_message_image)
    }

    override fun getLayout() = R.layout.item_image_message

    override fun isSameAs(other: com.xwray.groupie.Item<*>?): Boolean {
        if (other !is ImageMessage)
            return false
        if (this.message != other.message)
            return false
        return true
    }

    override fun equals(other: Any?): Boolean {
        return isSameAs(other as? ImageMessage)
    }

    override fun hashCode(): Int {
        var result = message.hashCode()
        result = 31 * result + context.hashCode()
        return result
    }
}