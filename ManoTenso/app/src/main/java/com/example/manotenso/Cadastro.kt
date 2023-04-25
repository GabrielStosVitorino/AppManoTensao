package com.example.manotenso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Cadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
    }

    fun cadastroCliente(componente: View) {
        val telaCadastroCliente = Intent(applicationContext, CadastroCliente::class.java)
        startActivity(telaCadastroCliente)
    }

    fun cadastroPrestador(componente: View) {
        val telaCadastroPrestador = Intent(applicationContext, CadastroPrestador::class.java)
        startActivity(telaCadastroPrestador)
    }

    fun voltarLogin(componente: View) {
        val telaLogin = Intent(applicationContext, Login::class.java)
        startActivity(telaLogin)
    }
}