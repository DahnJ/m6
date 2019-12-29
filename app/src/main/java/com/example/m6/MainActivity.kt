package com.example.m6


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.media.MediaPlayer
//import kotlin.random
//import android.app.Activity
//import android.media.MediaPlayer






class MainActivity : AppCompatActivity() {
    private val intervalsList = listOf("m2", "M2", "m3", "M3", "P4", "d5", "P5", "m6", "M6", "m7", "M7", "P8")
    //val map = mapOf("m2" to 1, "M2" to 2, "m3" to 3, "M3" to 4, "P4" to 5, "d5" to 6, "P5" to 7, "m6" to 8, "M6" to 9, "m7" to 10, "M7" to 11, "P8" to 12)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun interval(view: View){
        val intrvl = (0..11).random()
        val chosenOne = intervalsList[intrvl]
        val chosenPitch = (0..11).random()

        playSound(chosenPitch)
        Toast.makeText(this,chosenOne, Toast.LENGTH_LONG).show()
    }


    private fun playSound(pitch: Int) {
        val normalizedPitch = 20 + (pitch % 12) // 20 is C
        val filename = "p$normalizedPitch"
        val resourceId = resources.getIdentifier(filename, "raw", this.applicationInfo.packageName)

        val mediaPlayer: MediaPlayer? = MediaPlayer.create(this.applicationContext, resourceId)
        mediaPlayer?.start()
    }


}


