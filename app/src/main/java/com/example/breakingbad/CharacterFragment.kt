package com.example.breakingbad

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.example.breakingbad.Adapter.CharacterAdapter
import com.example.breakingbad.models.Character
import org.json.JSONArray

class CharacterFragment : Fragment() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_character, container, false)
        var characterArray=ArrayList<Character>()
        var count:Int=0

        val url: String = "https://www.breakingbadapi.com/api/characters"


        recyclerView = view.findViewById(R.id.character_recyclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val adapter=CharacterAdapter(characterArray)
        recyclerView.adapter=adapter
        Toast.makeText(context,"LMAOOOO + ${count}",Toast.LENGTH_SHORT).show()
        return view
    }


}

///     val character:Character= Character(characterObject.getString("name"),characterObject.getString("img"),characterObject.getString("potrayed"),characterObject.getString("birthday"),characterObject.getString("occupation"),characterObject.getString("nickname"),characterObject.getString("status"))
//
//characterArray.add(character)/