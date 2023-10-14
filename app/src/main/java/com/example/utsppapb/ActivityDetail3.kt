package com.example.utsppapb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.utsppapb.databinding.ActivityDetail3Binding
import com.example.utsppapb.databinding.ActivityDetailBinding
import com.example.utsppapb.databinding.ActivityHomeBinding

class ActivityDetail3 : AppCompatActivity() {
    private lateinit var binding: ActivityDetail3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetail3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            back.setOnClickListener {
                val intentToHomeActivity =
                    Intent (this@ActivityDetail3, HomeActivity::class.java)
                startActivity(intentToHomeActivity)
            }

            gettiket.setOnClickListener {
                val intentToDetailActivity =
                    Intent (this@ActivityDetail3, PaymentMethod::class.java)
                startActivity(intentToDetailActivity)
            }
        }

    }
}