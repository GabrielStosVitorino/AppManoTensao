package com.example.manotenso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CadastroClienteConcluido : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_cliente_concluido)
    }

    fun homeCliente(componente: View) {
        val tela = Intent(applicationContext, Home::class.java)
        startActivity(tela)
    }
}