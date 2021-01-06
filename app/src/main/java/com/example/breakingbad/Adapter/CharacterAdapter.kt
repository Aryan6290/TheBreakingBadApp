package com.example.breakingbad.Adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.breakingbad.R
import com.example.breakingbad.models.Character
import com.example.breakingbad.screens.Character_Info_Activity

class CharacterAdapter(val characterList: ArrayList<Character>) : RecyclerView.Adapter<CharacterHolder>() {
    private var mContext: Context?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
        val view:View= LayoutInflater.from(parent.context).inflate(
            R.layout.character_item,
            parent,
            false
        )
        mContext=parent.context
        return  CharacterHolder(view)

    }

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {


        val item=characterList[position]


        holder.name.text=item.name
        holder.name2.text=item.potrayed
        Glide.with(holder.itemView.context).load(item.imageUrl).into(holder.image)
        holder.image.setOnClickListener {
           // Toast.makeText(holder.image.context, item.name,Toast.LENGTH_SHORT).show()
            var intent= Intent(holder.image.context, Character_Info_Activity::class.java)
            intent.putExtra("name",item.name)
            intent.putExtra("birthday",item.birthday)
            intent.putExtra("url",item.imageUrl)
            intent.putExtra("nickname",item.nickname)
            intent.putExtra("occupation",item.occupation)
            intent.putExtra("potrayed",item.potrayed)
            intent.putExtra("status",item.status)




            holder.image.context.startActivity(intent)
        }


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


