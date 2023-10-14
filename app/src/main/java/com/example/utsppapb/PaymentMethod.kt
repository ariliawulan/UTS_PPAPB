package com.example.utsppapb

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.TimePicker
import com.example.utsppapb.databinding.ActivityPaymentMethodBinding
import kotlin.math.log

class PaymentMethod : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentMethodBinding
    private var selectedBioskop: String = " "
    private var selectedJudul: String = " "

    val bioskop = arrayOf(
        "Lippo Plaza Cinepolis",
        "Ambarukmo XXI",
        "Empire XXI Gejayan",
        "CGV Pakuwon Mall",
        "Sleman City Hall XXI"
    )

    val seat = arrayOf(
        "Reguler",
        "Executive",
        "Deluxe"
    )

    val payment = arrayOf(
        "Bank Transfer",
        "Gopay",
        "Dana",
        "Shopeepay",
        "LinkAja"
    )

    val bank = arrayOf(
        "Mandiri",
        "BCA",
        "BRI",
        "BNI",
        "BSI",
        "MEGA"
    )

    val judul = arrayOf(
        "Petualangan Sherina 2",
        "Air Mata di Ujung Sajadah",
        "Rembulan Tenggelam di Wajahmu",
        "Nanti Kita Cerita Tentang Hari Ini"
    )

    lateinit var dateTime: String

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentMethodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            back.setOnClickListener {
                val intentToHomeActivity =
                    Intent(this@PaymentMethod, HomeActivity::class.java)
                startActivity(intentToHomeActivity)
            }
        }

        with(binding) {
            order.setOnClickListener {
                val intentToOrderSummary =
                    Intent(this@PaymentMethod, OrderSummary::class.java)
                startActivity(intentToOrderSummary)
            }
        }

        with(binding) {

            val judulAdapter = ArrayAdapter(
                this@PaymentMethod,
                androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,
                judul
            )

            judulAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )

            spinjudul.adapter = judulAdapter
        }

        with(binding) {
            selectedBioskop =
                if (spinbioskop.selectedItemPosition != AdapterView.INVALID_POSITION) {
                    bioskop[spinbioskop.selectedItemPosition]
                } else {
                    // Handle ketika tidak ada item yang dipilih
                    "Pilih Bioskop"
                }

            val bioskopAdapter = ArrayAdapter(
                this@PaymentMethod,
                androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,
                bioskop
            )

            bioskopAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )

            spinbioskop.adapter = bioskopAdapter
        }

        with(binding) {

            val seatAdapter = ArrayAdapter(
                this@PaymentMethod,
                androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, seat
            )

            seatAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )

            spinseat.adapter = seatAdapter

            spinseat.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    val fee = when (spinseat.selectedItem.toString()) {
                        "Reguler" -> 35000
                        "Executive" -> 45000
                        "Deluxe" -> 55000
                        else -> 0
                    }

                    jenisSeat.text = spinseat.selectedItem.toString()
                    hargaSeat.text = fee.toString()
                    hargaSeat2.text = fee.toString()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }

        with(binding) {

            val paymentAdapter = ArrayAdapter(
                this@PaymentMethod,
                androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,
                payment
            )

            paymentAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )

            spinpayment.adapter = paymentAdapter

            spinpayment.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val selectedPayment = spinpayment.selectedItem.toString()

                    if (selectedPayment == "Bank Transfer") {
                        spinbank.visibility = View.VISIBLE
                        akunnumber.visibility = View.VISIBLE
                    } else {
                        spinbank.visibility = View.GONE
                        akunnumber.visibility = View.GONE
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // Kosong
                }
            }
            spinjudul.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    selectedJudul = spinjudul.selectedItem.toString()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }
            }
        }


        with(binding) {

            val bankAdapter = ArrayAdapter(
                this@PaymentMethod,
                androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, bank
            )

            bankAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )

            spinbank.adapter = bankAdapter
        }

        with(binding) {
            val datePicker = findViewById<DatePicker>(R.id.date_pick)
            val tahun = datePicker.year
            val bulan = datePicker.month + 1
            val hari = datePicker.dayOfMonth
            val tanggal = "$hari/$bulan/$tahun"

            val timePicker = findViewById<TimePicker>(R.id.time_pick)
            val jam = timePicker.currentHour
            val menit = timePicker.currentMinute
            val waktu = "$jam:$menit"
            dateTime = "$tanggal, $waktu"

        }

        with(binding) {

            order.setOnClickListener {

                val intent = Intent(this@PaymentMethod, OrderSummary::class.java)
                intent.putExtra("JUDUL", spinjudul.selectedItem.toString())
                intent.putExtra("BIOSKOP", spinbioskop.selectedItem.toString())
                intent.putExtra("PAYMENT", spinpayment.selectedItem.toString())
                intent.putExtra("SEAT", spinseat.selectedItem.toString())
                intent.putExtra("KELAS", hargaSeat.text.toString())
                intent.putExtra("FEE", hargaSeat2.text.toString())
                intent.putExtra("BANK", spinbank.selectedItem.toString())
                intent.putExtra("DATETIME", dateTime.toString())
                startActivity(intent)
            }
        }
    }
}