package com.example.tugas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val int = intent
        var name = int.getStringExtra( "name")
        var desc = int.getStringExtra( "description")
        var img = int.getStringExtra( "imageUrl")

        binding.imageTitle.text = name
        binding.imageDesc.text = desc
    }
}