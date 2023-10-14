package com.example.utsppapba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.utsppapba.databinding.ActivityDetailBinding

class detailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username2 = intent.getStringExtra(MainActivity.EXTRA_NAME)
        val film = intent.getParcelableExtra<Film>("film")
        if (film !=null){
            val textView : TextView = findViewById(R.id.detailedActivityTv)
            val imageView: ImageView = findViewById(R.id.imageview2)
            textView.text = film.name
            imageView.setImageResource(film.image)

        }
        with(binding){
            btndtlback.setOnClickListener(){
                val intentTohomeActivity = Intent(this@detailActivity, homeActivity::class.java)
                intentTohomeActivity.putExtra(MainActivity.EXTRA_NAME, username2)
                startActivity(intentTohomeActivity)
            }
            btndtlget.setOnClickListener(){
                val intentTopaymentActivity = Intent(this@detailActivity, paymentActivity::class.java)
                intentTopaymentActivity.putExtra(MainActivity.EXTRA_NAME, username2)
                intentTopaymentActivity.putExtra("film2",film)
                startActivity(intentTopaymentActivity)
            }
        }
    }
}