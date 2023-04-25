package com.example.manotenso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CadastroContatoPrestador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_contato_prestador)
    }

    fun cadastroEnderecoPrestador(componente: View) {
        val tela = Intent(applicationContext, CadastroEnderecoPrestador::class.java)
        startActivity(tela)
    }
}