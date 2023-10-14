package com.example.utsppapb

import android.content.Intent
import android.icu.text.SimpleDateFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.utsppapb.databinding.ActivityOrderSummaryBinding
import java.util.Date
import java.util.Locale

class OrderSummary : AppCompatActivity() {
    private lateinit var binding: ActivityOrderSummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderSummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val receiveBioskop = intent.getStringExtra("BIOSKOP")
        val receiveJudul = intent.getStringExtra("JUDUL")
        val receivePayment = intent.getStringExtra("PAYMENT")
        val receiveSeat = intent.getStringExtra("SEAT")
        val receiveKelas = intent.getStringExtra("KELAS")
        val receiveFee = intent.getStringExtra("FEE")
        val receiveDateTime = intent.getStringExtra("DATETIME")


        with(binding) {
            back.setOnClickListener {
                val intentToHomeActivity =
                    Intent(this@OrderSummary, PaymentMethod::class.java)
                startActivity(intentToHomeActivity)
            }

            Judulfilm.text = receiveJudul
            BioskopFilm.text = receiveBioskop
            jenisSeat.text = receiveSeat
            payment.text = receivePayment
            kelasSeat.text = receiveKelas
            fee2.text = receiveFee
            date5.text = receiveDateTime

        }
    }
}