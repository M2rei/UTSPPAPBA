package com.example.utsppapba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.utsppapba.databinding.ActivityPaymentBinding

class paymentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentBinding
    private val bioskopp = arrayOf(
        "Cinemaa XXI", "CGV", "Cinemaxx", "Independent", "New Star Cineplex","Platinum Cineplex"

    )
    private val jenistiket = arrayOf(
        "Tiket Biasa        :          Rp25.000",
        "Tiket VIP          :          Rp75.000",
        "Tiket 3D atau IMAX :          Rp125000",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var selectedbiskop = ""
        var selectedtiket = ""
        var selectedDate = ""
        var selectedTime = ""

        with(binding){
            val adapterType = ArrayAdapter(this@paymentActivity, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, bioskopp )
            val tiketadapter = ArrayAdapter(this@paymentActivity, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, jenistiket )

            adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerbioskop.adapter = adapterType
            tiketadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerjenistiket.adapter = tiketadapter

            spinnerbioskop.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?,position: Int, id: Long) {
                    selectedbiskop = bioskopp[position]
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    selectedbiskop = bioskopp[0]
                }
            })
            spinnerjenistiket.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?,position: Int, id: Long) {
                    selectedtiket = jenistiket[position]
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    selectedtiket = jenistiket[0]
                }
            })
            // date picker
            datePicker.init(
                datePicker.year,
                datePicker.month,
                datePicker.dayOfMonth
            ){_, year, monthOfYear, dayOfMonth ->
                selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
            }
            // timepicker
            timePicker.setOnTimeChangedListener{view, hourOfDay, minute ->
                selectedTime = String.format("%02d:%02d", hourOfDay, minute)
            }
            // end timepicker

            // button listener
            btnpaymen.setOnClickListener(){
                val selectedBioskop = selectedbiskop
                val selectedTiket = selectedtiket
                val selectedDate = selectedDate
                val selectedTime = selectedTime

                val intent = Intent(this@paymentActivity, orderActivity::class.java)
                intent.putExtra("selectedBioskop", selectedBioskop)
                intent.putExtra("selectedTiket", selectedTiket)
                intent.putExtra("selectedDate", selectedDate)
                intent.putExtra("selectedTime", selectedTime)
                startActivity(intent)
            }
        }
    }
}