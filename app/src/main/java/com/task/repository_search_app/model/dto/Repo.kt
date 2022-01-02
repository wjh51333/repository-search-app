package com.task.repository_search_app.model.dto

import com.google.gson.annotations.SerializedName

data class Repo(
    @SerializedName("id") val id : String,
    @SerializedName("owner") val owner : RepoOwner,
    @SerializedName("full_name") val name : String,
    @SerializedName("description") val desc : String,
    @SerializedName("html_url") val url : String
)
