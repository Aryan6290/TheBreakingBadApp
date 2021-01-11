package com.example.breakingbad

import android.os.Bundle
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
import com.example.breakingbad.Adapter.QuoteAdapter
import com.example.breakingbad.models.Episode
import com.example.breakingbad.models.Quotes
import org.json.JSONException


class EpisodesFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var qProgressBar: ProgressBar
    private var mAdapter: QuoteAdapter?=null
    var episodeList=ArrayList<Episode>()
    private val url: String ="https://www.breakingbadapi.com/api/quotes"


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
        recyclerView=view.findViewById(R.id.quotesRV)
        val verticalLayoutManager = LinearLayoutManager(activity)
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
                    var snippets=item.getJSONObject("snippets")
                    var title=snippets.getString("title")
                    var thumbnails=item.getJSONObject("thumbnails")
                    var medium=thumbnails.getJSONObject("medium")
                    var imageurl=medium.getString("url")

                    var resourceId=snippets.getJSONObject("resourceId")
                    var url=resourceId.getString("videoId")

                    var episode=Episode(title,url,imageurl)
                    episodeList.add(episode)




                }
                catch(e: JSONException){
                    e.printStackTrace()
                }


            }
//            mAdapter = QuoteAdapter(episodeList)
// attach adapter
            view?.findViewById<RecyclerView>(R.id.quotesRV)?.adapter =mAdapter


            mAdapter?.notifyDataSetChanged()
            qProgressBar.visibility=View.GONE



        }, {

        })
        queue.add(jsonObjectRequest)
    }
}