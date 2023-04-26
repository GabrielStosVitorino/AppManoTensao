package com.example.manotenso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.manotenso.databinding.ActivityCadastroEnderecoPrestadorBinding

class CadastroEnderecoPrestador : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroEnderecoPrestadorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroEnderecoPrestadorBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun recuperarDados() {
        val dadosPrestadorr = intent.getSerializableExtra("dadosPrestadores") as dadosPrestador
        dadosPrestadorr.nome
        dadosPrestadorr.cnpj
        dadosPrestadorr.dtNascimento
        dadosPrestadorr.senha
        dadosPrestadorr.email
        dadosPrestadorr.telefone
    }

    fun cadastroSobreMim(componente: View) {

        val cep = binding.etCep.text.toString()
        val bairro = binding.etBairro.text.toString()
        val logradouro = binding.etLogradouro.text.toString()
        val numero = binding.etNumero.text.toString()
        val complemento = binding.etComplemento.text.toString()

        val dadosPrestadores = dadosPrestador(cep, bairro, logradouro, numero, complemento)
        println(dadosPrestadores)
        val tela = Intent(applicationContext, CadastroSobreMimPrestador::class.java)
        tela.putExtra("dadosCliente", dadosPrestadores)
        startActivity(tela)
    }
}