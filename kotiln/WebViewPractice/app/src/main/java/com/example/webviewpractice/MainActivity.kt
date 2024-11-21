package com.example.webviewpractice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.webviewpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val webView = binding.webView

        webView.loadUrl("https://www.google.com")


        binding.btnGoogle.setOnClickListener {
            webView.loadUrl("https://www.google.com")
        }
        binding.btnCoupang.setOnClickListener {
            webView.loadUrl("https://www.tistory.com/")
        }
        binding.btnComiler.setOnClickListener {
            webView.loadUrl("https://www.onlinegdb.com/online_c_compiler")
        }
    }
}