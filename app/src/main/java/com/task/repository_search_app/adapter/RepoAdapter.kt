package com.task.repository_search_app.adapter

import android.app.LauncherActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.task.repository_search_app.R
import com.task.repository_search_app.databinding.ListItemRepoBinding
import com.task.repository_search_app.model.dto.Repo

private const val TAG = "RepoAdapter"
class RepoAdapter(private val repoList : List<Repo>)
    : RecyclerView.Adapter<RepoAdapter.RepoHolder>() {

    inner class RepoHolder(private val binding: ListItemRepoBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data : Repo) {
            binding.apply {
                repo = data
                itemView.tag = data
            }

            if (data.desc.isNullOrEmpty()) {
                binding.desc.visibility = View.GONE
            }

            itemView.setOnClickListener {
                itemClickListener.onClick(it, data.url)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoHolder {
        val binding = DataBindingUtil.inflate<ListItemRepoBinding>(
            LayoutInflater.from(parent.context), R.layout.list_item_repo, parent, false
        )
        return RepoHolder(binding)
    }

    override fun onBindViewHolder(holder: RepoHolder, position: Int) {
        val repo = repoList[position]
        holder.bind(repo)
    }

    override fun getItemCount() = repoList.size

    interface ItemClickListener {
        fun onClick(view : View, url : String)
    }

    private lateinit var itemClickListener : ItemClickListener

    fun setItemClickListener(itemClickListener : ItemClickListener) {
        this.itemClickListener = itemClickListener
    }
}