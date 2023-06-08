package com.example.manotenso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CadastroContatoCliente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_contato_cliente)
    }

    fun cadastroEndereco(componente: View){
        val dadosCliente = intent.getSerializableExtra("dadosCliente") as Cliente

        val email = findViewById<EditText>(R.id.et_email).text.toString()
        val telefone = findViewById<EditText>(R.id.et_telefone).text.toString()

        dadosCliente.email = email
        dadosCliente.telefone = telefone

        val tela = Intent(applicationContext, CadastroEnderecoCliente::class.java)

        tela.putExtra("dadosCliente", dadosCliente)
        startActivity(tela)
    }
}