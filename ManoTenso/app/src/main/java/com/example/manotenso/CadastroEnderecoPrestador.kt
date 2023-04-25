package com.example.manotenso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CadastroEnderecoPrestador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_endereco_prestador)
    }

    fun cadastroSobreMim(componente: View) {
        val tela = Intent(applicationContext, CadastroSobreMimPrestador::class.java)
        startActivity(tela)
    }
}