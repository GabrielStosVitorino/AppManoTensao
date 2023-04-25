package com.example.manotenso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CadastroSobreMimPrestador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_sobre_mim_prestador)
    }

    fun cadastroConcluidoPrestador(componente: View) {
        val tela = Intent(applicationContext, CadastroPrestadorConcluido::class.java)
        startActivity(tela)
    }
}