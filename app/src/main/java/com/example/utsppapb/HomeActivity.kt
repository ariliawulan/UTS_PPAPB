package com.example.utsppapb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.utsppapb.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = intent.getStringExtra(LoginActivity.EXTRA_USN)
        with(binding) {
            username.text = "$name"
            sherina.setOnClickListener{
                val intentToHomeActivity =
                    Intent (this@HomeActivity, DetailActivity::class.java)
                startActivity(intentToHomeActivity)
            }

            airmata.setOnClickListener{
                val intentToHomeActivity =
                    Intent (this@HomeActivity, ActivityDetail2::class.java)
                startActivity(intentToHomeActivity)
            }

            rembulan.setOnClickListener{
                val intentToHomeActivity =
                    Intent (this@HomeActivity, ActivityDetail3::class.java)
                startActivity(intentToHomeActivity)
            }

            kitacerita.setOnClickListener{
                val intentToHomeActivity =
                    Intent (this@HomeActivity, ActivityDetail4::class.java)
                startActivity(intentToHomeActivity)
            }
        }
    }
}