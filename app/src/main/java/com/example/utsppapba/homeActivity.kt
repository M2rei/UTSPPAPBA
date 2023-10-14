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

        val username = intent.getStringExtra(MainActivity.EXTRA_NAME)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        filmList = ArrayList()

        filmList.add(Film(R.drawable.monkey, "The Monkey King"))
        filmList.add(Film(R.drawable.legion, "Legion of Super Heroes"))
        filmList.add(Film(R.drawable.elephant, "The Magician's Elephant"))
        filmList.add(Film(R.drawable.marioo, "The Super Mario Bros. Movie"))
        filmList.add(Film(R.drawable.evil, "Resident Evil: Death Island"))
        filmList.add(Film(R.drawable.nimona, "Nimona"))

        filmAdapter = FilmAdapter(filmList)
        recyclerView.adapter = filmAdapter

        filmAdapter.onItemClick = {
            val intentTodetailActivity = Intent(this@homeActivity, detailActivity::class.java)
            intentTodetailActivity.putExtra("film", it)
            startActivity(intentTodetailActivity)
        }
        with(binding){
            tkshome2.text = username
        }
    }
}