package com.example.manotenso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.manotenso.databinding.ActivityCadastroContatoPrestadorBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CadastroContatoPrestador : AppCompatActivity() {
    private lateinit var binding: ActivityCadastroContatoPrestadorBinding
    lateinit var dadosPrestador: DadosPrestador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroContatoPrestadorBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun cadastroEnderecoPrestador(componente: View) {
        val dadosPrestador = intent.getSerializableExtra("dadosPrestadores") as DadosPrestador

        val email = findViewById<EditText>(R.id.et_email).text.toString()
        val telefone = findViewById<EditText>(R.id.et_telefone).text.toString()

        dadosPrestador.email = email
        dadosPrestador.telefone = telefone

        val tela = Intent(applicationContext, CadastroEnderecoPrestador::class.java)
        tela.putExtra("dadosPrestadores", dadosPrestador)
        startActivity(tela)
    }
}