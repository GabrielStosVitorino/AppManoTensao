package com.example.manotenso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.manotenso.databinding.ActivityCadastroInfosClienteBinding
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CadastroInfosCliente : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroInfosClienteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroInfosClienteBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

   fun cadastroContato(componente: View) {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val nomeCompleto = binding.etNomeCompleto.text.toString()
        val cpf = binding.etCpf.text.toString()
        val nascimento = LocalDate.parse((binding.etDataNascimento.text.toString()), formatter)
        val senha = binding.etCrieSenha.text.toString()

        val dadosCliente = dadosCliente(nomeCompleto, cpf, nascimento, senha)

        val tela = Intent(applicationContext, CadastroContatoCliente::class.java)

        tela.putExtra("dadosCliente", dadosCliente)
        startActivity(tela)
    }
}