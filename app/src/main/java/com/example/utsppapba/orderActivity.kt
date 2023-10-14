package com.example.utsppapba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.utsppapba.databinding.ActivityOrderBinding

class orderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val selectedBioskop = intent.getStringExtra("selectedBioskop")
        val selectedTiket = intent.getStringExtra("selectedTiket")
        val selectedDate = intent.getStringExtra("selectedDate")
        val selectedTime = intent.getStringExtra("selectedTime")

        with(binding){
            order1.text = selectedBioskop
            order2.text = selectedTiket
            order3.text = selectedDate
            order4.text = selectedTime

        }
    }
}