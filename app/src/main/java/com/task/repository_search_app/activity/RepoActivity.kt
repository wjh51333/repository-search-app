package com.task.repository_search_app.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.task.repository_search_app.R
import com.task.repository_search_app.databinding.ActivityRepoBinding

class RepoActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRepoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRepoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = intent.getStringExtra("url")!!
        binding.webView.loadUrl(url)
    }
}