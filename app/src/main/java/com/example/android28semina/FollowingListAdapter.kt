package com.example.android28semina

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android28semina.databinding.ItemUserInfoBinding

class FollowingListAdapter : RecyclerView.Adapter<FollowingListAdapter.FollowingUserViewHolder>() {


    lateinit var binding: ItemUserInfoBinding

    val userList = mutableListOf<User>()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FollowingUserViewHolder {
        binding = ItemUserInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return FollowingUserViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: FollowingUserViewHolder,
        position: Int
    ) {
        holder.onBind(userList[position])
    }

    override fun getItemCount(): Int = userList.size

    class FollowingUserViewHolder(
        private val binding: ItemUserInfoBinding

    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(user: User) {
            binding.textView5.text = user.userName
        }
    }


}