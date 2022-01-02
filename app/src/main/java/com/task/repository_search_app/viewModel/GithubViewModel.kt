package com.task.repository_search_app.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.repository_search_app.model.dto.Repo
import com.task.repository_search_app.repository.GithubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "GithubViewModel"
class GithubViewModel(private val githubRepository : GithubRepository) : ViewModel() {
    private val _repos = MutableLiveData<List<Repo>>()
    val repos : LiveData<List<Repo>> = _repos

    fun searchRepos(query : String) {
        viewModelScope.launch(Dispatchers.IO) {
            githubRepository.searchRepos(query)?.let { response ->
                if (response.isSuccessful) {
                    response.body()?.let {
                        _repos.postValue(it.items)
                        Log.d(TAG, "searchRepos: ${_repos.value}")
                    }
                }
            }
        }
    }
}