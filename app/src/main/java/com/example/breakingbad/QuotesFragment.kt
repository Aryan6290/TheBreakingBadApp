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
import com.android.volley.toolbox.Volley
import com.example.breakingbad.Adapter.CharacterAdapter
import com.example.breakingbad.Adapter.QuoteAdapter
import com.example.breakingbad.models.Character
import com.example.breakingbad.models.Quotes
import org.json.JSONException


class QuotesFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var qProgressBar: ProgressBar
    private var mAdapter:QuoteAdapter?=null
   var quotesList=ArrayList<Quotes>()
    private val url: String ="https://www.breakingbadapi.com/api/quotes"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quotes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        qProgressBar=view.findViewById(R.id.QprogressBar)
        qProgressBar.visibility=View.VISIBLE
        recyclerView=view.findViewById(R.id.quotesRV)
        val verticalLayoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = verticalLayoutManager
        getData()
    }

    private fun getData() {

        val queue = Volley.newRequestQueue(activity)
        var jsonArrayRequest= JsonArrayRequest(Request.Method.GET,url,null, {
            for(i in 0 until it.length()){
                try{
                  val quotesObject=it.getJSONObject(i)
                  val message=quotesObject.getString("quote")
                  val author=quotesObject.getString("author")

                    val quote:Quotes= Quotes(message,author)
                    quotesList.add(quote)

                }
                catch(e: JSONException){
                    e.printStackTrace()
                }


            }
            mAdapter = QuoteAdapter(quotesList)
// attach adapter
            view?.findViewById<RecyclerView>(R.id.quotesRV)?.adapter =mAdapter


            mAdapter?.notifyDataSetChanged()
            qProgressBar.visibility=View.GONE



        }, {

        })
        queue.add(jsonArrayRequest)
    }
}