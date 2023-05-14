package com.example.manotenso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.manotenso.databinding.ActivityCadastroInfosClienteBinding

class CadastroInfosCliente : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroInfosClienteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroInfosClienteBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

   fun cadastroContato(componente: View) {
        val nomeCompleto = binding.etNomeCompleto.text.toString()
        val cpf = binding.etCpf.text.toString()
        val nascimento = binding.etDataNascimento.text.toString()
        val senha = binding.etCrieSenha.text.toString()

        val dadosCliente = DadosCliente(nomeCompleto, cpf, nascimento, senha)

        val tela = Intent(applicationContext, CadastroContatoCliente::class.java)

        tela.putExtra("dadosCliente", dadosCliente)
        startActivity(tela)
    }
}