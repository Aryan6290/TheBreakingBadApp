package com.example.breakingbad

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.Response.Listener
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.breakingbad.Adapter.CharacterAdapter
import com.example.breakingbad.models.Character
import com.example.breakingbad.utils.MySingleton
import org.json.JSONArray
import org.json.JSONObject

class CharacterFragment : Fragment() {
    var count: Int = 0
    lateinit var recyclerView: RecyclerView
    private var mAdapter:CharacterAdapter?=null
    private var characterList:ArrayList<Character>()

    private var url:String="https://www.breakingbadapi.com/api/characters"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_character, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    private fun getData(){
        var jsonArrayRequest=JsonArrayRequest(Request.Method.GET,url,null, {


        }, {

        })
    }
}


