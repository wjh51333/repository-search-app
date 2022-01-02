package com.task.repository_search_app.model.service

import com.task.repository_search_app.model.response.RepoSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {

    @GET("/search/repositories")
    suspend fun searchRepos(@Query("q") q : String) : Response<RepoSearchResponse>

}