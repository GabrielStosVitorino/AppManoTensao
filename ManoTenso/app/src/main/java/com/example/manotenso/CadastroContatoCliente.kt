package com.example.manotenso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class CadastroContatoCliente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_contato_cliente)

        val nomeCompleto = intent.getStringExtra("nomeCompleto")
        val cpf = intent.getStringExtra("cpf")
        val nascimento = intent.getStringExtra("nascimento")
        val senha = intent.getStringExtra("senha")
    }

    fun cadastroEndereco(componente: View) {

        val email = findViewById<EditText>(R.id.et_email).text.toString()
        val telefone = findViewById<EditText>(R.id.et_telefone).text.toString()

        val tela = Intent(applicationContext, CadastroEnderecoCliente::class.java)
        tela.putExtra("email", email)
        tela.putExtra("telefone", telefone)
        startActivity(tela)
    }
}