package com.example.countdowntimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), OnClickListener{
    lateinit var countdownText : TextView
    lateinit var pauseButton : Button
    var isStart = false

    var seconds = 0
    var minutes = 0
    var hours = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countdownText = findViewById(R.id.countdown_Text)
        pauseButton = findViewById(R.id.pause_button)

        countdownText.text = "${hours.toString().padStart(2, '0')}:" +
                "${minutes.toString().padStart(2, '0')}:" +
                "${seconds.toString().padStart(2, '0')}"

        pauseButton.setOnClickListener(this)
        StartTimer()
    }

    fun StartTimer(){ // Start Timer
        if(isStart){
            if (seconds < 60) {
                seconds++
            } else if (minutes < 60) {
                seconds = 0
                minutes++
            } else if (hours < 60) {
                seconds = 0
                minutes = 0
                hours++
            }
        }
    }

    override fun onClick(v: View?) {
        isStart = !isStart
    }
}