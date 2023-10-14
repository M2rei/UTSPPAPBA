package com.example.utsppapba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import com.example.utsppapba.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    companion object{
        const val EXTRA_NAME = "extra_name"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            btnlgn.setOnClickListener {
                val username = usernamelgn.text.toString()
                val password = passwordlgn.text.toString()
                if (username == "Muflih Raihan" && password == "22/503413/SV/21502"){
                    val intentTohomeActivity =
                        Intent(this@MainActivity, homeActivity::class.java)
                    intentTohomeActivity.putExtra(EXTRA_NAME, usernamelgn.text.toString())
                    startActivity(intentTohomeActivity)
                }
                else{
                    Toast.makeText(this@MainActivity, "Username atau Password salah", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}