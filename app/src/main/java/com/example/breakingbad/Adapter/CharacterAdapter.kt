package com.example.breakingbad.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.breakingbad.R
import com.example.breakingbad.models.Character
import org.w3c.dom.Text

class CharacterAdapter(val characterList: ArrayList<Character>) : RecyclerView.Adapter<CharacterHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
        val view:View= LayoutInflater.from(parent.context).inflate(R.layout.character_item,parent,false)

        return  CharacterHolder(view)

    }

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {

        val item=characterList[position]
        holder.name.text=item.name
        holder.name2.text=item.potrayed
        Glide.with(holder.itemView.context).load(item.imageUrl).into(holder.image)

    }

    override fun getItemCount(): Int {
        return characterList.size
    }


}
class CharacterHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    val name=itemView.findViewById<TextView>(R.id.character_name)
    val name2=itemView.findViewById<TextView>(R.id.actor_name)
    val image:ImageView=itemView.findViewById(R.id.character_image)


}

