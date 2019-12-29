package com.example.m6


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.media.MediaPlayer


class MainActivity : AppCompatActivity() {
    private val INTERVALS = listOf("m2", "M2", "m3", "M3", "P4", "d5", "P5", "m6", "M6", "m7", "M7", "P8")
    private val PITCHES = (0..11)
    private val DIRECTIONS = listOf("up", "down")
    //val map = mapOf("m2" to 1, "M2" to 2, "m3" to 3, "M3" to 4, "P4" to 5, "d5" to 6, "P5" to 7, "m6" to 8, "M6" to 9, "m7" to 10, "M7" to 11, "P8" to 12)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun interval(view: View){
        val chosenOne = INTERVALS.random()
        val chosenPitch = PITCHES.random()
        val chosenDirection = DIRECTIONS.random()

        playPitch(chosenPitch)
        Toast.makeText(this, "$chosenOne $chosenDirection", Toast.LENGTH_LONG).show()
    }

    private fun playPitch(pitch: Int) {
        val normalizedPitch = 28 + (pitch % 12) // 28 is C
        val filename = "p$normalizedPitch"
        val resourceId = resources.getIdentifier(filename, "raw", this.applicationInfo.packageName)

        val mediaPlayer: MediaPlayer? = MediaPlayer.create(this.applicationContext, resourceId)
        mediaPlayer?.start()
    }
}
