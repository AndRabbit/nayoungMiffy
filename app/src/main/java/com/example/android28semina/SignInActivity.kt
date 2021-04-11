package com.example.android28semina

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.android28semina.databinding.ActivitySigninBinding

class SignInActivity : AppCompatActivity() {


    private lateinit var signInViewModel: SignInViewModel

    lateinit var binding: ActivitySigninBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        signInViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            SignInViewModel::class.java
        )
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signin)
        binding.vm = signInViewModel
        binding.lifecycleOwner = this
        setListeners()


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


    private fun setListeners() {
        binding.signInButton.setOnClickListener {
            if (binding.editTextTextPersonName.text.isNotEmpty() && binding.editTextTextPassword.text.isNotEmpty()) {
                startActivity(Intent(this, HomeActivity::class.java))
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()

            } else {

                Toast.makeText(this, "아이디/비밀번호를 확인해주세요!", Toast.LENGTH_SHORT).show()
            }

        }
        binding.signUpText.setOnClickListener {
            //startActivity(Intent(this,SignUpActivity::class.java))
            signUpActivityLauncher.launch(Intent(this, SignUpActivity::class.java))

        }
    }

    private val signUpActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        // 데이터를 받아서 할 일이 들어가는 칸! 과제에선 여기까지만 만들어주세요
        if (it.resultCode == Activity.RESULT_OK) {

        }

    }
}