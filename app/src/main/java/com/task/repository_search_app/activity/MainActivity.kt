package com.task.repository_search_app.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.task.repository_search_app.R
import com.task.repository_search_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}