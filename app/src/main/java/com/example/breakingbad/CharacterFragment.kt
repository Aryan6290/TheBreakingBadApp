package com.example.breakingbad

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.breakingbad.models.Character

class CharacterFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var characterArray:ArrayList<Character>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View= inflater.inflate(R.layout.fragment_character, container, false)
        recyclerView= view.findViewById(R.id.character_recyclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager=LinearLayoutManager(activity)
        return view
    }


}