package com.example.utsppapba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.utsppapba.databinding.ActivityOrderBinding

class orderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOrderBinding
    private var tanggal: String? = null
    private var jam: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username4 = intent.getStringExtra(MainActivity.EXTRA_NAME)
        val bbioskop = intent.getStringExtra(paymentActivity.jnsbioskop)
        val tikett= intent.getStringExtra(paymentActivity.jnstiket)
        val ppembayaran = intent.getStringExtra(paymentActivity.jnspembayaran)
        val film3 = intent.getParcelableExtra<Film>("film3")
        if (film3 !=null){
            val textView : TextView = findViewById(R.id.text2)

            textView.text = film3.name

        }

        tanggal = intent.getStringExtra("tanggal")
        jam = intent.getStringExtra("jam")
        with(binding){
            text4.text = bbioskop
            text6.text = tikett
            text8.text = ppembayaran
            text10.text= "$tanggal"
            text12.text= "$jam"
            ussername.text = username4
        }
    }
}