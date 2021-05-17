package com.example.android28semina

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.android28semina.api.ServiceCreator
import com.example.android28semina.data.RequestLogin
import com.example.android28semina.data.RequestSignUp
import com.example.android28semina.data.ResponseLogin
import com.example.android28semina.data.ResponseSignUp
import com.example.android28semina.databinding.ActivitySignUpBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {


    private lateinit var signUpViewModel: SignUpViewModel

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUpViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(SignUpViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        binding.vm = signUpViewModel
        binding.lifecycleOwner = this

        observeData()
        setListeners()
    }


    override fun onResume() {
        super.onResume()
        Log.d("resume", "생명주기")
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
        signUpViewModel.signUpComplete.observe(this){
            if(it==true){
                Toast.makeText(this@SignUpActivity,signUpViewModel.inputId.value,Toast.LENGTH_SHORT).show()
                val intent = Intent()
                intent.putExtra("name", binding.nameEdit.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
            else{
                Toast.makeText(this, "빈 칸이 있는지 확인해 주세요!", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun setListeners() {

        binding.signUpButton.setOnClickListener {
            signUpViewModel.signUpCheck()
        }
    }
}