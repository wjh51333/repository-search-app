package com.task.repository_search_app.model.dto

import com.google.gson.annotations.SerializedName

data class RepoOwner(
    @SerializedName("avatar_url") val avatar : String
)
