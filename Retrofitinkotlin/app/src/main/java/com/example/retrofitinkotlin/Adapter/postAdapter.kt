package com.example.retrofitinkotlin.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitinkotlin.R
import com.example.retrofitinkotlin.model.post
import java.lang.StringBuilder

class postAdapter(internal var contecxt: Context, internal var postList:List<post>)
    :RecyclerView.Adapter<postHandler>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): postHandler {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_layout,parent,false)
        return postHandler(itemView)

    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: postHandler, position: Int) {
        holder.text_title.text = postList[position].title
        holder.text_author.text = postList[position].userId.toString()
        holder.text_content.text = StringBuilder(postList[position].body.substring(0,20))
            .append("...").toString()

    }

}


