package com.example.manotenso

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.manotenso.databinding.ActivityProfileBinding

class Profile : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.getIntExtra("id", 0)

        val btnVoltar = findViewById<ImageView>(R.id.iv_arrow_back)
        btnVoltar.setOnClickListener {
            onBackPressed()
        }
        val whats = findViewById<Button>(R.id.btn_whats)
        whats.setOnClickListener {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
            sendIntent.type = "text/plain"
            sendIntent.setPackage("com.whatsapp")
            startActivity(sendIntent)
        }
    }
}

