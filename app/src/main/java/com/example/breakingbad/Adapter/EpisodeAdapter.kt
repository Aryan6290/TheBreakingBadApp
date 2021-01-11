package com.example.breakingbad.Adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.breakingbad.R
import com.example.breakingbad.models.Episode


class EpisodeAdapter(val episodeList: ArrayList<Episode>) : RecyclerView.Adapter<EpisodeHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeHolder {
        val view:View= LayoutInflater.from(parent.context).inflate(
            R.layout.episode_item,
            parent,
            false
        )

        return  EpisodeHolder(view)
    }

    override fun onBindViewHolder(holder: EpisodeHolder, position: Int) {
        val item=episodeList[position]
        holder.name.text=item.title


        Glide.with(holder.itemView.context).load(item.thumbnail).into(holder.image)
        holder.image.setOnClickListener {
            val intent: Intent =Intent(Intent.ACTION_VIEW)
            intent.setPackage("com.google.android.youtube");
            intent.setData(Uri.parse("https://www.youtube.com/watch?v=${item.url}"));
            holder.image.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {

        return  episodeList.size
    }
}

class EpisodeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name=itemView.findViewById<TextView>(R.id.ep_title)

    val image: ImageView =itemView.findViewById(R.id.thumbnail)


}