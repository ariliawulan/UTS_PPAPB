package com.example.utsppapb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.utsppapb.databinding.ActivityDetailBinding
import com.example.utsppapb.databinding.ActivityHomeBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            back.setOnClickListener {
                val intentToHomeActivity =
                    Intent (this@DetailActivity, HomeActivity::class.java)
                startActivity(intentToHomeActivity)
            }

            gettiket.setOnClickListener {
                val intentToDetailActivity =
                    Intent (this@DetailActivity, PaymentMethod::class.java)
                startActivity(intentToDetailActivity)
            }
        }

    }
}