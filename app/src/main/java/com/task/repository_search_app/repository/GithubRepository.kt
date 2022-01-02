package com.task.repository_search_app.repository

import com.task.repository_search_app.config.ApplicationClass
import com.task.repository_search_app.model.service.GithubService

class GithubRepository {
    private val githubService = ApplicationClass.retrofit.create(GithubService::class.java)

    suspend fun searchRepos(query : String) = githubService.searchRepos(query)

}