package com.example.manotenso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CadastroInfosPrestador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_infos_prestador)
    }

    fun cadastroContatoPrestador(componente: View) {
        val tela = Intent(applicationContext, CadastroContatoPrestador::class.java)
        startActivity(tela)
    }
}