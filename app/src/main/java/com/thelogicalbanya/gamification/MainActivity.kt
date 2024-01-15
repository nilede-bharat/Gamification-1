package com.thelogicalbanya.gamification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: WebViewGemification = findViewById<WebViewGemification>(R.id.button)
        button.loadUrl(clientID = "demo", key = "demo", userID = "100031", username = "TheLogicalBanya")

    }
}