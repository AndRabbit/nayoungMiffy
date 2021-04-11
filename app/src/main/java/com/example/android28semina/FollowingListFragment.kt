package com.example.android28semina

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android28semina.databinding.FragmentFollowListBinding

class FollowingListFragment : Fragment() {


    lateinit var binding: FragmentFollowListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFollowListBinding.inflate(inflater, container, false)




        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val followingListAdapter = FollowingListAdapter()

        binding.followingListRecyclerView.adapter = followingListAdapter

        followingListAdapter.userList.addAll(
            listOf(User("http://", "영나"))
        )
        followingListAdapter.notifyDataSetChanged()


    }
}