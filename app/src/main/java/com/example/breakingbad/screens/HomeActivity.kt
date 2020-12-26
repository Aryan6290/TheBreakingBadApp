package com.example.breakingbad.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.breakingbad.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNavigationView=findViewById<BottomNavigationView>(R.id.bottom_nav)
        val navController=findNavController(R.id.fragment)
        val appBarConfiguration= AppBarConfiguration(setOf(R.id.characterFragment,R.id.episodesFragment,R.id.quotesFragment,R.id.aboutFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavigationView.setupWithNavController(navController)

    }
}