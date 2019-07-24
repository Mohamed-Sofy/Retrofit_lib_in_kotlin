package com.example.retrofitinkotlin.Adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.post_layout.view.*

class postHandler(itemView: View) :RecyclerView.ViewHolder(itemView)
{
    val text_title = itemView.text_title
    val text_content = itemView.text_content
    val text_author = itemView.text_author
}