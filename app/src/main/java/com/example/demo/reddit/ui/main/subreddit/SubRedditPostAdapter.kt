package com.example.demo.reddit.ui.main.subreddit

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
import kotlinx.android.synthetic.main.item_sub_reddit_post.view.*

class SubRedditPostAdapter(
    private val onPostClicked: (Child) -> Unit,
    private val onVoteIconClicked: (Pair<Int, Child>) -> Unit
) :
    RecyclerView.Adapter<SubRedditPostAdapter.ViewHolder>() {

    var postList = mutableListOf<Child>()
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        this.context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sub_reddit_post, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = postList.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(postList[position], position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(child: Child, position: Int) = with(itemView) {
            val data = child.data

            postedBy.text = "u/${data?.author}"
            postTitle.text = data?.title ?: ""
            Glide.with(context)
                .load(data?.thumbnail)
                .override(data?.thumbnailWidth ?: 0, data?.thumbnailHeight ?: 0)
                .into(postImage)
            votes.text = data?.score.toString()
            comments.text = data?.numComments.toString()

            upVote.setOnClickListener {
                val pair = Pair(position, child)
                onVoteIconClicked(pair)
            }
            downVote.setOnClickListener {
                val pair = Pair(position, child)
                onVoteIconClicked(pair)
            }
            if (child.data?.userHasFavorited == true) {
                upVote.setTint(R.color.textBlack)
            } else {
                upVote.setTint(R.color.lightGrey)
            }
        }

        fun ImageView.setTint(@ColorRes colorRes: Int) {
            ImageViewCompat.setImageTintList(
                this,
                ColorStateList.valueOf(ContextCompat.getColor(context, colorRes))
            )
        }

    }
}
