package com.example.utsppapb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.utsppapb.databinding.ActivityDetail4Binding
import com.example.utsppapb.databinding.ActivityDetailBinding
import com.example.utsppapb.databinding.ActivityHomeBinding

class ActivityDetail4 : AppCompatActivity() {
    private lateinit var binding: ActivityDetail4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetail4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = intent.getStringExtra(LoginActivity.EXTRA_USN)
        with(binding) {
            back.setOnClickListener {
                val intentToHomeActivity =
                    Intent (this@ActivityDetail4, HomeActivity::class.java)
                startActivity(intentToHomeActivity)
            }

            gettiket.setOnClickListener {
                val intentToDetailActivity =
                    Intent (this@ActivityDetail4, PaymentMethod::class.java)
                startActivity(intentToDetailActivity)
            }
        }

    }
}