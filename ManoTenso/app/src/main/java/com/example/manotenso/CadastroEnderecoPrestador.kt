package com.example.manotenso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.manotenso.databinding.ActivityCadastroEnderecoPrestadorBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CadastroEnderecoPrestador : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroEnderecoPrestadorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroEnderecoPrestadorBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun cadastroSobreMim(componente: View) {
        val dadosPrestador = intent.getSerializableExtra("dadosPrestadores") as DadosPrestador

        val cep = findViewById<EditText>(R.id.et_cep).text.toString()
        val bairro = findViewById<EditText>(R.id.et_bairro).text.toString()
        val numero = findViewById<EditText>(R.id.et_numero).text.toString().toInt()
        val complemento = findViewById<EditText>(R.id.et_complemento).text.toString()

        dadosPrestador.cep = cep
        dadosPrestador.bairro = bairro
        dadosPrestador.numero = numero
        dadosPrestador.complemento = complemento


        val tela = Intent(applicationContext, CadastroSobreMimPrestador::class.java)
        tela.putExtra("dadosPrestadores", dadosPrestador)
        startActivity(tela)
    }
}