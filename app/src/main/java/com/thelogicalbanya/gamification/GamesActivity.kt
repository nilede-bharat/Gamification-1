package com.thelogicalbanya.gamification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class GamesActivity : AppCompatActivity() {

    var webViewGamification: WebViewGamification? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)
        webViewGamification= findViewById(R.id.button)
        val keyString = ""
        val baseUrl = ""

        webViewGamification?.init(clientID = "", key = "", userID = "",
         username = "",keyString = keyString, baseUrl = baseUrl)

    }

    override fun onBackPressed() {
        if (!webViewGamification?.onBackPressed()!!) {
            super.onBackPressed()
        }
    }

}
