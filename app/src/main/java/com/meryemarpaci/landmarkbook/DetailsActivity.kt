package com.meryemarpaci.landmarkbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.meryemarpaci.landmarkbook.databinding.ActivityDetailsBinding
import com.meryemarpaci.landmarkbook.databinding.ActivityMainBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = intent
        //casting
        val selectedCats=intent.getSerializableExtra("cats") as cats
        binding.nameText.text=selectedCats.name
        binding.infoText.text=selectedCats.info
        binding.imageView.setImageResource(selectedCats.img)

    }
}