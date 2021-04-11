package com.example.android28semina

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.android28semina.databinding.ActivitySignUpBinding

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


    private fun setListeners() {

        binding.signUpButton.setOnClickListener {
            if (binding.nameEdit.text.isNotEmpty() && binding.editTextTextPersonName.text.isNotEmpty() && binding.editTextTextPassword.text.isNotEmpty()) {
                val intent = Intent()
                intent.putExtra("id", binding.nameEdit.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()

            } else {
                Toast.makeText(this, "빈 칸이 있는지 확인해 주세요!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}