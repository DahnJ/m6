package com.example.m6


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.media.MediaPlayer
import android.widget.TextView
import kotlin.math.abs


class MainActivity : AppCompatActivity() {
    private val INTERVAL_NAMES = listOf("m2", "M2", "m3", "M3", "P4", "d5", "P5", "m6", "M6", "m7", "M7", "P8")
    private val INTERVALS = listOf(-12, -11, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    private val PITCHES = (0..11)
    //val map = mapOf("m2" to 1, "M2" to 2, "m3" to 3, "M3" to 4, "P4" to 5, "d5" to 6, "P5" to 7, "m6" to 8, "M6" to 9, "m7" to 10, "M7" to 11, "P8" to 12)

    private var question = 0
    private var answer = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun interval(view: View){
        val chosenPitch = PITCHES.random()
        val intervalSemitones = INTERVALS.random()

        playPitch(chosenPitch)
        val textview = findViewById<TextView>(R.id.intervalTextView)
        textview.text = parseIntervalName(intervalSemitones)

        question = chosenPitch
        answer = chosenPitch + intervalSemitones
    }

    fun answerButton(view: View){
        playPitch(answer)
    }

    fun repeatButton(view: View){
        playPitch(question)
    }

    private fun parseIntervalName(interval: Int): String{
        val direction = if (interval < 0) "down" else "up"
        val intervalName = INTERVAL_NAMES[abs(interval) - 1]
        return "$intervalName $direction"
    }

    private fun playPitch(pitch: Int) {
        val normalizedPitch = 28 + pitch // 28 is C
        val filename = "p$normalizedPitch"
        val resourceId = resources.getIdentifier(filename, "raw", this.applicationInfo.packageName)

        val mediaPlayer: MediaPlayer? = MediaPlayer.create(this.applicationContext, resourceId)
        mediaPlayer?.start()
    }
}
