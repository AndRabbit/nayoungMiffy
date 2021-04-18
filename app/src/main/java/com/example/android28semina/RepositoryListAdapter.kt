package com.example.android28semina

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android28semina.databinding.ItemRepositoryBinding
import com.example.android28semina.databinding.ItemUserInfoBinding

class RepositoryListAdapter: RecyclerView.Adapter<RepositoryListAdapter.RepositoryListViewHolder>() {

    lateinit var binding:ItemRepositoryBinding

     var repositoryList= mutableListOf<Repository>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RepositoryListAdapter.RepositoryListViewHolder {
        binding = ItemRepositoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RepositoryListAdapter.RepositoryListViewHolder(binding)
    }
    override fun onBindViewHolder(holder: RepositoryListViewHolder, position: Int) {
        holder.onBind(repositoryList[position])
    }


    override fun getItemCount(): Int =repositoryList.size

    class RepositoryListViewHolder(
        private val binding: ItemRepositoryBinding

    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(repository: Repository) {

            binding.repoTitle.text=repository.title
            binding.repoDetail.text=repository.detail
            binding.repoLanguage.text=repository.language

        }
    }


}