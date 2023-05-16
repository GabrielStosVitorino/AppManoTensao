package com.example.manotenso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.manotenso.databinding.ActivityCadastroInfosPrestadorBinding

class CadastroInfosPrestador : AppCompatActivity() {
    private lateinit var binding: ActivityCadastroInfosPrestadorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroInfosPrestadorBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun cadastroContatoPrestador(componente: View) {

        val nomeCompleto = binding.etNomeCompleto.text.toString()
        val cnpj = binding.etCnpj.text.toString()
        val nascimento = binding.etDataNascimento.text.toString()
        val senha = binding.etCrieSenha.text.toString()

        val dadosPrestador = DadosPrestador(nomeCompleto, cnpj, nascimento, senha)

        val tela = Intent(applicationContext, CadastroContatoPrestador::class.java)
        tela.putExtra("dadosPrestadores", dadosPrestador)
        startActivity(tela)
    }
}