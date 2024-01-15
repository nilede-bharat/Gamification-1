package com.thelogicalbanya.gamification

import android.content.Context
import android.util.AttributeSet
import android.util.Base64
import android.view.LayoutInflater
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.constraintlayout.widget.ConstraintLayout
import com.github.mervick.aes_everywhere.Aes256
import com.thelogicalbanya.gamification.databinding.LayoutWebviewBinding
import java.net.URLEncoder

class WebViewGemification constructor(context : Context ,attrs : AttributeSet): ConstraintLayout(context , attrs){

    private var binding : LayoutWebviewBinding? = null
    init {
       binding = LayoutWebviewBinding.inflate(LayoutInflater.from(context),this ,true)
        loadWebview()
    }

     fun loadWebview() {
         loadUrl(clientID = "", key = "", userID = "", username = "")
    }

    fun loadUrl(clientID : String,key : String,userID:String,username:String){
        val keyString = "bR5z6*r$00p#Eno__odrEgeW"
        val baseUrl = "https://thelogicalbanya.com/popupdemo/dashboard.php"
        // Your original JSON string
        val originalJson = """
        {
          "clientID": "$clientID",
          "key": "$key",
          "userID": "$userID",
          "username": "$username"
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

            val webView = findViewById<WebView>(R.id.gemification_webview)
            webView.loadUrl(finalUrl)
            webView.settings.javaScriptEnabled = true
            webView.webViewClient = WebViewClient()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}