package com.example.breakingbad.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.breakingbad.CharacterFragment
import com.example.breakingbad.R
import com.example.breakingbad.models.Character

class Character_Info_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character__info_)
        val intent=intent
        val ss: String? = intent.getStringExtra("occupation")
        findViewById<TextView>(R.id.name_detail).text=ss
    }
}