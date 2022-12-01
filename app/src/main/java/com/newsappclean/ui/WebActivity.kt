package com.newsappclean.ui

import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.newsappclean.databinding.ActivityWebBinding

class WebActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebBinding
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)

        webView = binding.webView

        val intent: Intent? = intent
        val url = intent!!.getStringExtra("url_key")
        webView.loadUrl(url!!)
    }

    override fun onRestart() {
        super.onRestart()
        finish()
    }
}