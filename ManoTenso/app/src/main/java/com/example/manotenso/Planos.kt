package com.example.manotenso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.manotenso.databinding.ActivityCadastroInfosClienteBinding
import com.example.manotenso.databinding.ActivityPlanosBinding

class Planos : AppCompatActivity() {
    private lateinit var binding: ActivityPlanosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlanosBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun basico(componente: View) {
        val tela = Intent(applicationContext, PagamentoCartao::class.java)
        tela.putExtra("plano", "Básico")
        tela.putExtra("valor", "R$29,99")
        startActivity(tela)
    }

    fun premium(componente: View) {
        val tela = Intent(applicationContext, PagamentoCartao::class.java)
        tela.putExtra("plano", "Premium")
        tela.putExtra("valor", "R$109,99")
        startActivity(tela)
    }

    fun pro(componente: View) {
        val tela = Intent(applicationContext, PagamentoCartao::class.java)
        tela.putExtra("plano", "Pro")
        tela.putExtra("valor", "R$74,99")
        startActivity(tela)
    }
}