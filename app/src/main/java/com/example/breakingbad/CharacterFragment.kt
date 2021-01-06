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
import org.json.JSONException
import org.json.JSONObject

public class CharacterFragment : Fragment() {
    var count: Int = 0
    lateinit var recyclerView: RecyclerView
    private var mAdapter:CharacterAdapter?=null
    public var characterList=ArrayList<Character>()

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
        recyclerView = view.findViewById<RecyclerView>(R.id.character_recyclerview)
        val verticalLayoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = verticalLayoutManager
        getData()

    }
    private fun getData(){

        val queue = Volley.newRequestQueue(activity)
        var jsonArrayRequest=JsonArrayRequest(Request.Method.GET,url,null, {
            for(i in 0 until it.length()){
                    try{
                        val characterObject=it.getJSONObject(i)
                        val name= characterObject.getString("name")
                        val img= characterObject.getString("img")
                        val portrayed= characterObject.getString("portrayed")
                        val birthday= characterObject.getString("birthday")
                        val occupationArray= characterObject.getJSONArray("occupation")
                        var occupation:String=""
                        for (i in 0 until occupationArray.length()){
                            if(i!=occupationArray.length()-1){
                                occupation+=(occupationArray[i].toString() +","+"\n")
                            }
                            else
                                occupation+=occupationArray[i]


                        }
                        val nickname= characterObject.getString("nickname")
                        val status= characterObject.getString("status")
                        val character=Character(name,img,portrayed,birthday,occupation,nickname,status)
                        characterList.add(character)
                    }
                    catch(e:JSONException){
                        e.printStackTrace()
                    }


            }
            mAdapter = CharacterAdapter(characterList)
// attach adapter
            view?.findViewById<RecyclerView>(R.id.character_recyclerview)?.adapter =mAdapter


            mAdapter?.notifyDataSetChanged()


        }, {

        })
        queue.add(jsonArrayRequest)
    }
}


