package com.example.breakingbad.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.breakingbad.R
import com.example.breakingbad.models.Character

class CharacterAdapter(val characterList: ArrayList<Character>) : RecyclerView.Adapter<CharacterHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {

        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return characterList.size
    }


}
class CharacterHolder(val itemView: View) : RecyclerView.ViewHolder(itemView){

}

