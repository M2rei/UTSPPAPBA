package com.example.utsppapba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.utsppapba.databinding.ActivityHomeBinding

class homeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var filmList: ArrayList<Film>
    private lateinit var filmAdapter : FilmAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        filmList = ArrayList()

        filmList.add(Film(R.drawable.contoh, "judul 1"))
        filmList.add(Film(R.drawable.contoh, "judul 2"))
        filmList.add(Film(R.drawable.contoh, "judul 3"))
        filmList.add(Film(R.drawable.contoh, "judul 4"))
        filmList.add(Film(R.drawable.contoh, "judul 5"))
        filmList.add(Film(R.drawable.contoh, "judul 6"))

        filmAdapter = FilmAdapter(filmList)
        recyclerView.adapter = filmAdapter

        filmAdapter.onItemClick = {
            val intentTodetailActivity = Intent(this@homeActivity, detailActivity::class.java)
            intentTodetailActivity.putExtra("film", it)
            startActivity(intentTodetailActivity)
        }
    }
}