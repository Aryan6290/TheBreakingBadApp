package com.example.breakingbad.Adapter

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.breakingbad.R
import com.example.breakingbad.models.Quotes

class QuoteAdapter(val quotesList:ArrayList<Quotes>): RecyclerView.Adapter<QuotesHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.quote_item,parent,false)
        return QuotesHolder(view)
    }

    override fun onBindViewHolder(holder: QuotesHolder, position: Int) {
       val item=quotesList[position]
        holder.dialogue.text="\""+item.quote+"\""
        holder.author.text="- "+item.speaker
        holder.icon.setOnClickListener{
            var myClipboard = holder.icon.context!!.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            var myClip: ClipData = ClipData.newPlainText("note_copy", item.quote)
            myClipboard.setPrimaryClip(myClip)

             Toast.makeText(holder.icon.context, "Quote copied to Clipboard !",Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
       return quotesList.size
    }
}

class QuotesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val dialogue:TextView=itemView.findViewById(R.id.message)
    val author:TextView=itemView.findViewById(R.id.author_name)
    val icon:ImageView=itemView.findViewById(R.id.clipboard_icon)

}