package com.example.breakingbad.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.breakingbad.CharacterFragment
import com.example.breakingbad.R
import com.example.breakingbad.models.Character

class Character_Info_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character__info_)

        val intent=intent
        for(i in 0 until 20){
            Log.i("hello world","woohooo")
        }
        val name: String? = intent.getStringExtra("name")
        val url: String? = intent.getStringExtra("url")

        val nickname: String? = intent.getStringExtra("nickname")
        val status: String? = intent.getStringExtra("status")
        val birthday: String? = intent.getStringExtra("birthday")
        val portrayed: String? = intent.getStringExtra("potrayed")
        val occupation: String? = intent.getStringExtra("occupation")
        supportActionBar?.title = "$name"


        findViewById<TextView>(R.id.name).text=name
        findViewById<TextView>(R.id.nickname).text=nickname
        findViewById<TextView>(R.id.status).text=status
        findViewById<TextView>(R.id.birthday).text=birthday
        findViewById<TextView>(R.id.occupation).text=occupation
        findViewById<TextView>(R.id.potrayed).text=portrayed


        val imageView=findViewById<ImageView>(R.id.image)
        Glide.with(this).load(url).into(imageView)

    }
}