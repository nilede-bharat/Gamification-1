package com.thelogicalbanya.gamification

import android.content.Context
import android.util.AttributeSet
import android.util.Base64
import android.util.Log
import android.view.LayoutInflater
import android.webkit.WebViewClient
import androidx.constraintlayout.widget.ConstraintLayout
import com.github.mervick.aes_everywhere.Aes256
import com.thelogicalbanya.gamification.databinding.LayoutWebviewBinding
import java.net.URLEncoder

class WebViewGamification constructor(context : Context, attrs : AttributeSet): ConstraintLayout(context , attrs){

    private var binding : LayoutWebviewBinding? = null

    init {
       binding = LayoutWebviewBinding.inflate(LayoutInflater.from(context),this ,true)
        loadWebview()
    }

     fun loadWebview() {
         init(clientID = "", key = "", userID = "", username = "", keyString = "", baseUrl = "")
    }

    fun init(
        clientID: String,
        key: String,
        userID: String,
        username: String,
        keyString: String,
        baseUrl: String,
        utm_param1: String = "",
        utm_param2: String = "",
        utm_param3: String = "",
        utm_param4: String = ""
    ) {

        // Your original JSON string
        val originalJson = """
        {
          "clientID": "$clientID",
          "key": "$key",
          "userID": "$userID",
          "username": "$username",
          "utm_param1": "$utm_param1",
          "utm_param2": "$utm_param2",
          "utm_param3": "$utm_param3",
          "utm_param4": "$utm_param4",
          "utm_source":"Android"
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
            Log.e("Final Url",finalUrl)


           binding?.gamificationWebview?.settings?.javaScriptEnabled = true
            binding?.gamificationWebview?.webViewClient = WebViewClient()
            binding?.gamificationWebview?.settings?.mediaPlaybackRequiresUserGesture = false
            binding?.gamificationWebview?.loadUrl(finalUrl)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun onBackPressed(): Boolean {
        return if (binding?.gamificationWebview?.canGoBack() == true) {
            binding?.gamificationWebview?.goBack()
            true // Consumed the back button event
        } else {
            false // Didn't consume the back button event
        }
    }

}