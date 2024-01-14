package com.thelogicalbanya.gamification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.webkit.WebView
import android.webkit.WebViewClient
import com.github.mervick.aes_everywhere.Aes256
import java.net.URLEncoder

class Gamification : AppCompatActivity() {
    private val keyString = "bR5z6*r$00p#Eno__odrEgeW"
    val baseUrl = "https://thelogicalbanya.com/popupdemo/dashboard.php"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gamification)
        loadUrl()
    }

    fun loadUrl(){
        // Your original JSON string
        val originalJson = """
            {
              "clientID": "demo",
              "key": "demo",
              "userID": "100031",
              "username": "TheLogicalBanya"
            }
        """.trimIndent()

        try {
            val encryptedData = Aes256.encrypt(originalJson, keyString)

            // Base64 encode the encrypted data
            val base64EncodedData = Base64.encodeToString(encryptedData.toByteArray(), Base64.DEFAULT)

            // Encode the base64Encoded data for URL
            val encodedData = URLEncoder.encode(base64EncodedData, "UTF-8")

            // Construct the final URL
            val finalUrl = "$baseUrl?data=$encodedData"

            val webView = findViewById<WebView>(R.id.webview)
            webView.loadUrl(finalUrl)
            webView.settings.javaScriptEnabled = true
            webView.webViewClient = WebViewClient()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}