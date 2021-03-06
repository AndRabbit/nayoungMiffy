package com.example.android28semina

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.android28semina.api.ServiceCreator
import com.example.android28semina.data.RequestLogin
import com.example.android28semina.data.ResponseLogin
import com.example.android28semina.databinding.ActivitySigninBinding

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        observeData()


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

    private fun observeData(){
        signInViewModel.loginCheckValue.observe(this){
            if(it==true){
                Toast.makeText(this@SignInActivity,
                    "login success",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
            }
            else{
                Toast.makeText(this, "?????????/??????????????? ??????????????????!", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun setListeners() {
        binding.signInButton.setOnClickListener {
            signInViewModel.loginCheck()
                //Toast.makeText(this, "????????? ??????", Toast.LENGTH_SHORT).show()

        }
        binding.signUpText.setOnClickListener {
            signUpActivityLauncher.launch(Intent(this, SignUpActivity::class.java))

        }
    }

    private val signUpActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        // ???????????? ????????? ??? ?????? ???????????? ???! ???????????? ??????????????? ??????????????????
        if (it.resultCode == RESULT_OK) {
            Toast.makeText(this, it.data?.getStringExtra("name"), Toast.LENGTH_LONG).show()

        }
    }
}