package com.thelogicalbanya.gamification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class GamesActivity : AppCompatActivity() {

    var webViewGamification: WebViewGamification? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)
        webViewGamification= findViewById(R.id.button)
        val keyString = "bR5z6*r$00p#Eno__odrEgeW"
        val baseUrl = "https://thelogicalbanya.com/popupdemo/dashboard.php"
        webViewGamification?.init(clientID =    "demo", key = "demo", userID = "100031", username = "TheLogicalBanya",keyString = keyString, baseUrl = baseUrl)

    }

    override fun onBackPressed() {
        if (!webViewGamification?.onBackPressed()!!) {
            super.onBackPressed()
        }
    }

}