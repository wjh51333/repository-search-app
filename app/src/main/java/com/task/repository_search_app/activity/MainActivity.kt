package com.task.repository_search_app.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.task.repository_search_app.R
import com.task.repository_search_app.adapter.RepoAdapter
import com.task.repository_search_app.databinding.ActivityMainBinding
import com.task.repository_search_app.model.dto.Repo
import com.task.repository_search_app.repository.GithubRepository
import com.task.repository_search_app.viewModel.GithubViewModel
import com.task.repository_search_app.viewModel.GithubViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : GithubViewModel
    private lateinit var viewModelFactory : GithubViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModelFactory = GithubViewModelFactory(GithubRepository())
        viewModel = ViewModelProvider(this, viewModelFactory).get(GithubViewModel::class.java)

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {
                query?.let { viewModel.searchRepos(query!!) }
                viewModel.repos.observe(this@MainActivity) { repos ->
                    initAdapter(repos)
                }
                return true
            }
        })
    }

    private fun initAdapter(repos : List<Repo>) {

    }
}