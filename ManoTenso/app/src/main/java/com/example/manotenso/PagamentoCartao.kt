package com.example.manotenso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class PagamentoCartao : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagamento_cartao)

        val tipoPlano = findViewById<TextView>(R.id.tv_tipo_plano)
        val valorPlano = findViewById<TextView>(R.id.tv_valor_plano)

        val planos = intent.extras
        val tipo = planos?.getString("plano")
        val valor = planos?.getString("valor")

        tipoPlano.text = tipo
        valorPlano.text = valor
    }

    fun concluido(componente: View) {
        val tela = Intent(applicationContext, CadastroPrestadorConcluido::class.java)
        startActivity(tela)
    }
}