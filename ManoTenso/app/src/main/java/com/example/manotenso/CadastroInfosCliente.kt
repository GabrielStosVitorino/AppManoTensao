package com.example.manotenso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class CadastroInfosCliente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_infos_cliente)
    }

    fun cadastroContato(componente: View) {

        val nomeCompleto = findViewById<EditText>(R.id.et_nome_completo).text.toString()
        val cpf = findViewById<EditText>(R.id.et_cpf).text.toString()
        val nascimento = findViewById<EditText>(R.id.et_data_nascimento).text.toString()
        val senha = findViewById<EditText>(R.id.et_input_senha).text.toString()

        val tela = Intent(applicationContext, CadastroContatoCliente::class.java)

        tela.putExtra("nomeCompleto", nomeCompleto)
        tela.putExtra("cpf", cpf)
        tela.putExtra("nascimento", nascimento)
        tela.putExtra("senha", senha)
        startActivity(tela)
    }
}