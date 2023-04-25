package com.example.manotenso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CadastroPrestadorConcluido : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_prestador_concluido)
    }

    fun homePrestador(componente: View) {
        val tela = Intent(applicationContext, HomePrestador::class.java)
        startActivity(tela)
    }
}