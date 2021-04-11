package com.example.android28semina

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android28semina.databinding.ActivityUserInfoBinding

class UserInfoActivity : AppCompatActivity() {


    lateinit var binding: ActivityUserInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityUserInfoBinding.inflate(layoutInflater)

        val followingListFragment = FollowingListFragment()

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.userInfoFragment, followingListFragment)
        transaction.commit()

        setContentView(R.layout.activity_user_info)
    }
}