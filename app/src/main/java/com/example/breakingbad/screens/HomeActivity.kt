package com.example.breakingbad.screens

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import android.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.breakingbad.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val toolbar=findViewById<androidx.appcompat.widget.Toolbar>(R.id.my_toolbar)
        setSupportActionBar(toolbar)
        val image5:ImageView?=findViewById(R.id.imageView5)
        mediaPlayer = MediaPlayer.create(this,R.raw.intro1)
        mediaPlayer!!.isLooping = true // Set looping
        mediaPlayer!!.setVolume(100f, 100f)
        mediaPlayer!!.start()
        var flag=1;
        findViewById<ImageView>(R.id.imageView5).setOnClickListener{
            if (flag==1){
                image5?.setBackgroundResource(R.drawable.ic_baseline_music_off_24)
                mediaPlayer!!.pause()
                mediaPlayer!!.seekTo(0)

                flag=0

            }
            else if(flag==0){
                mediaPlayer!!.start()
                image5?.setBackgroundResource(R.drawable.ic_baseline_music_note_24)
                flag=1
            }



        }
        val bottomNavigationView=findViewById<BottomNavigationView>(R.id.bottom_nav)
        val navController=findNavController(R.id.fragment)
        val appBarConfiguration= AppBarConfiguration(setOf(R.id.characterFragment,R.id.episodesFragment,R.id.quotesFragment,R.id.aboutFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavigationView.setupWithNavController(navController)

    }
}