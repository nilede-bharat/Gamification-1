package com.thelogicalbanya.gamification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class GamesActivity : AppCompatActivity() {

    var webViewGemification: WebViewGemification? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)
        webViewGemification= findViewById(R.id.button)
        webViewGemification?.init(clientID =    "demo", key = "demo", userID = "100031", username = "TheLogicalBanya")

    }

    override fun onBackPressed() {
        if (!webViewGemification?.onBackPressed()!!) {
            super.onBackPressed()
        }
    }

}