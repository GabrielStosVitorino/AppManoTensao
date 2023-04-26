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
    lateinit var dadosPrestador: dadosPrestador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroContatoPrestadorBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun cadastrarPrestador(componente: View){
        val dadosPrestador = intent.getSerializableExtra("dadosPrestadores") as dadosPrestador

        val email = binding.etEmail.text.toString()
        val telefone = binding.etTelefone.text.toString()

        val novoUsuario = Prestador (
            nome = dadosPrestador.nome,
            cpf = dadosPrestador.cnpj,
            dtNascimento = dadosPrestador.dtNascimento,
            senha = dadosPrestador.senha,
            email = email,
            telefone = telefone
        )

        val tela = Intent(applicationContext, CadastroPrestadorConcluido::class.java)

        val api = Apis.getApi()
        val chamada = api.postPrestador(novoUsuario)
        chamada.enqueue(object : Callback<Prestador> {
        override fun onResponse(call: Call<Prestador>, response: Response<Prestador>) {
                val resposta = response.body()
                if (resposta != null) {
                    startActivity(tela)
                } else {
                    println("Segundo else cliente")
                    println(resposta)
                    println(novoUsuario)
                }
            }

            override fun onFailure(call: Call<Prestador>, t: Throwable) {
                Toast.makeText(baseContext, "Erro na API: ${t.message}",
                    Toast.LENGTH_SHORT).show()
                t.printStackTrace()
            }
        })
    }

    fun cadastroEnderecoPrestador(componente: View) {

        val email = binding.etEmail.text.toString()
        val telefone = binding.etTelefone.text.toString()

        val dadosPrestadores = dadosPrestador(email, telefone)

        val tela = Intent(applicationContext, CadastroEnderecoPrestador::class.java)
        tela.putExtra("dadosCliente", dadosPrestadores)
        println(dadosPrestadores)
        startActivity(tela)
    }
}