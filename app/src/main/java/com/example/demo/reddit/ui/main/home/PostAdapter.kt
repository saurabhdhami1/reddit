package com.example.demo.reddit.ui.main.home

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demo.reddit.R
import com.example.demo.reddit.data.remote.models.Child
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter(
    private val onPostClicked: (Child) -> Unit,
    private val onVoteIconClicked: (Pair<Int, Child>) -> Unit
) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    var postList = mutableListOf<Child>()
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        this.context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = postList.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(postList[position], position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(child: Child, position: Int) = with(itemView) {
            val data = child.data
            profileName.text = data?.title
            Glide.with(context)
                .load(data?.bannerImg)
                .into(postImage)
            /*likeIcon.setOnClickListener {
                val pair = Pair(position, child)
                onVoteIconClicked(pair)
            }*/
            Glide.with(context)
                .load(data?.iconImg)
                .into(profileImage)
            profileName.text = data?.headerTitle
            postHeading.text = data?.title
            postDescription.text = data?.publicDescription

            itemView.setOnClickListener { onPostClicked(child) }
            /*if (child.data?.userHasFavorited == true) {
                likeIcon.setTint(R.color.textBlack)
            } else {
                likeIcon.setTint(R.color.lightGrey)
            }*/
        }

        fun ImageView.setTint(@ColorRes colorRes: Int) {
            ImageViewCompat.setImageTintList(
                this,
                ColorStateList.valueOf(ContextCompat.getColor(context, colorRes))
            )
        }

    }
}
