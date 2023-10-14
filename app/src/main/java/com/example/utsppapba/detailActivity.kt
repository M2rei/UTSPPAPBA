package com.example.utsppapba

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

        val film = intent.getParcelableExtra<Film>("film") as? Film
        if (film !=null){
            val textView : TextView = findViewById(R.id.textView)
            val imageView: ImageView = findViewById(R.id.imageview)

            textView.text = film.name
            imageView.setImageResource(film.image)
        }
    }
}