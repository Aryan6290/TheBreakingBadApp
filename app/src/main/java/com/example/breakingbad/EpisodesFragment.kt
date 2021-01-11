package com.example.breakingbad

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.breakingbad.Adapter.EpisodeAdapter
import com.example.breakingbad.Adapter.QuoteAdapter
import com.example.breakingbad.models.Episode
import com.example.breakingbad.models.Quotes
import org.json.JSONException


class EpisodesFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var qProgressBar: ProgressBar
    private var mAdapter: EpisodeAdapter?=null
    var episodeList=ArrayList<Episode>()
    private val url: String ="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet%2CcontentDetails&maxResults=100&playlistId=PL4XYugONL7lZRsu295MZDZ5Lm6WWsC76E&key=AIzaSyBnqQgi5SAoaSqfsmXWOrCwE89sOkp0ypI"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_episodes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView=view.findViewById(R.id.episodeRV)
        val verticalLayoutManager = LinearLayoutManager(activity)
        qProgressBar=view.findViewById(R.id.progressBar3)
        qProgressBar.visibility=View.VISIBLE
        recyclerView.layoutManager = verticalLayoutManager
        getData()
    }

    private fun getData() {
        val queue = Volley.newRequestQueue(activity)
        var jsonObjectRequest= JsonObjectRequest(Request.Method.GET,url,null, {
            var jsonArray=it.getJSONArray("items")



            for(i in 0 until jsonArray.length()){
                try{

                    var item=jsonArray.getJSONObject(i)
                    var snippets=item.getJSONObject("snippet")
                    var title=snippets.getString("title")
                    var thumbnails=snippets.getJSONObject("thumbnails")
                    var highres=thumbnails.getJSONObject("maxres")
                    var imageurl=highres.getString("url")

                    var resourceId=snippets.getJSONObject("resourceId")
                    var url=resourceId.getString("videoId")

                    var episode=Episode(title,url,imageurl)
                    episodeList.add(episode)
                    Log.i("JSONPROCESS","$imageurl")




                }
                catch(e: JSONException){
                    e.printStackTrace()
                }


            }
            Log.i("JSONPROCESS2","$jsonArray")

            mAdapter = EpisodeAdapter(episodeList)
// attach adapter
            view?.findViewById<RecyclerView>(R.id.episodeRV)?.adapter =mAdapter


            mAdapter?.notifyDataSetChanged()
            qProgressBar.visibility=View.GONE



        }, {

        })
        queue.add(jsonObjectRequest)
    }
}