package com.example.utsppapb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.utsppapb.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    companion object {
        const val EXTRA_USN = "extra_usn"
        const val EXTRA_PASS = "extra_pass"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            login.setOnClickListener {
                val intentToLoginActivity =
                    Intent (this@LoginActivity, HomeActivity::class.java)
                intentToLoginActivity.putExtra(EXTRA_USN, username.text.toString())
                intentToLoginActivity.putExtra(EXTRA_PASS, password.text.toString())
                startActivity(intentToLoginActivity)
            }
        }
    }
}