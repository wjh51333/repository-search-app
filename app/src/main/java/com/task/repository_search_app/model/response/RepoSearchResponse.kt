package com.task.repository_search_app.model.response

import android.content.ClipData
import com.google.gson.annotations.SerializedName
import com.task.repository_search_app.model.dto.Repo

data class RepoSearchResponse(
    @SerializedName("totalCount") val total_count: Int,
    @SerializedName("items") val items: List<Repo>
)
