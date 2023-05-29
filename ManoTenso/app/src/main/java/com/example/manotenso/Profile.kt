package com.example.manotenso

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.manotenso.databinding.ActivityProfileBinding
import com.squareup.picasso.Picasso
import java.net.URLEncoder
import java.util.*

class Profile : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val prestadorNome = intent.getStringExtra("prestadorNome")
        val prestadorDescricao = intent.getStringExtra("prestadorDescricao")
        val prestadorFoto = intent.getStringExtra("prestadorFoto")
        val prestadorLinkWhatsapp = intent.getStringExtra("prestadorLinkWhatsapp")
        val fotoPrestador = binding.ivPhoto

        binding.tvNome.text = prestadorNome
        binding.tvPerfil.text = prestadorDescricao
        var urlFoto: String? =
            "https://filestore.community.support.microsoft.com/api/images/6061bd47-2818-4f2b-b04a-5a9ddb6f6467?upload=true&fud_access=wJJIheezUklbAN2ppeDns8cDNpYs3nCYjgitr%2BfFBh2dqlqMuW7np3F6Utp%2FKMltnRRYFtVjOMO5tpbpW9UyRAwvLeec5emAPixgq9ta07Dgnp2aq5eJbnfd%2FU3qhn5498QChOTHl3NpYS7xR7zASsaF20jo4ICSz2XTm%2B3GDR4XitSm7nHRR843ku7uXQ4oF6innoBxMaSe9UfrAdMi7owFKjdP9m1UP2W5KAtfQLNQqewpIgNm8TVO4GO5v9sGqgqs3xWAuztC7LdeU1uK5MlYEg4tcMW8ax1kJeEuI7GF14QRdq%2FnahToC7uRfuyqXfrNDVU7TRYmeyQhkHZT14xQvDhOtAZUQgwPgSV7MB43JrYAXNh8fJC6Ja0mJH8pVl6qWr%2F6VLaLsMefSMUp6P6zavS%2F%2F0ocUyQZKumNlok%3D"

        if (Objects.nonNull(prestadorFoto)) {
            urlFoto = prestadorFoto
        }

        Picasso.get().load(urlFoto).into(fotoPrestador)

        val btnVoltar = findViewById<ImageView>(R.id.iv_arrow_back)
        btnVoltar.setOnClickListener {
            onBackPressed()
        }
        val whats = findViewById<Button>(R.id.btn_whats)
        whats.setOnClickListener {
            openWhatsApp()
        }
    }

    private fun openWhatsApp() {
        val prestadorLinkWhatsapp = intent.getStringExtra("prestadorLinkWhatsapp")
        val phoneNumber = prestadorLinkWhatsapp
        val message = "Olá! Gostaria de um orçamento"

        try {
            // Cria um Uri com o formato do link do WhatsApp
            val url = "https://api.whatsapp.com/send?phone=$phoneNumber&text=${URLEncoder.encode(message, "UTF-8")}"

            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

