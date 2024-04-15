package com.thelogicalbanya.gamification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var confirm_button: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        confirm_button= findViewById<Button>(R.id.confirm_button)
        confirm_button?.setOnClickListener {
           startActivity(Intent(this,GamesActivity::class.java))
        }

    }

}