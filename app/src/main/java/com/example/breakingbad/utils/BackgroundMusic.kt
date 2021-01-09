
package com.example.breakingbad.utils
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.ImageView
import android.widget.Toast
import com.example.breakingbad.R


class BackgroundMusic : Service() {
    var mediaPlayer: MediaPlayer? = null
    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()

        mediaPlayer = MediaPlayer.create(this,R.raw.intro1 )
        mediaPlayer!!.isLooping = true // Set looping
        mediaPlayer!!.setVolume(100f, 100f)
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        mediaPlayer!!.start()
        Toast.makeText(
            applicationContext,
            "Playing Bohemian Rashpody in the Background",
            Toast.LENGTH_SHORT
        ).show()
        return startId
    }

    override fun onStart(intent: Intent, startId: Int) {}
    override fun onDestroy() {
        mediaPlayer!!.stop()
        mediaPlayer!!.release()
    }

    override fun onLowMemory() {}
}