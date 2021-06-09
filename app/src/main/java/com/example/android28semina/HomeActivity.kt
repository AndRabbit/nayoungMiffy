package com.example.android28semina

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.android28semina.common.MySharedPreferences
import com.example.android28semina.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityHomeBinding.inflate(layoutInflater)



        setContentView(binding.root)


        setListeners()
        setAdapter()
    }



    private fun setListeners(){
        binding.userInfoBtn.setOnClickListener {
            startActivity(Intent(this,UserInfoActivity::class.java))
        }
        binding.logOutBtn.setOnClickListener {
            MySharedPreferences.clearUser(this)
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun setAdapter(){
        val repositoryListAdapter = RepositoryListAdapter()

        binding.repositoryRecyclerView.adapter = repositoryListAdapter

        repositoryListAdapter.repositoryList.addAll(
            listOf(Repository("android 28 semina sopt", "28기 솝트 안드로이드 파트 정규 세미나 활동을 기록하기 위한 레포지터리이다.","kotlin"),
                Repository("healingfeeling", "덕성여자대학교 4학년 졸업작품 활동을 기록하기 위한 레포지터리이다.","java"))
        )
        repositoryListAdapter.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        Log.d("resume", this.toString())
    }

    override fun onPause() {
        super.onPause()
        Log.d("pause", this.toString())
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("destroy", this.toString())
    }

    override fun onStart() {
        super.onStart()
        Log.d("start", this.toString())
    }

    override fun onStop() {
        super.onStop()
        Log.d("stop", this.toString())
    }
}