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

class CadastroEnderecoCliente : AppCompatActivity() {

    lateinit var dadosCliente: dadosCliente
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_endereco_cliente)
        dadosCliente = intent.getSerializableExtra("dadosCliente") as dadosCliente
    }

    fun recuperarDados() {
        val dadosCliente = intent.getSerializableExtra("dadosCliente") as dadosCliente

    }

    fun cadastrarCliente(componente: View){
        val dadosCliente = intent.getSerializableExtra("dadosCliente") as dadosCliente

        val cep = findViewById<EditText>(R.id.et_cep).text.toString()
        val bairro = findViewById<EditText>(R.id.et_bairro).text.toString()
        val logradouro = findViewById<EditText>(R.id.et_logradouro).text.toString()
        val numero = findViewById<EditText>(R.id.et_numero).text.toString()
        val complemento = findViewById<EditText>(R.id.et_complemento).text.toString()


        val novoUsuario = Cliente (
            nome = dadosCliente.nomeCompleto,
            cpf = dadosCliente.cpf,
            dtNascimento = dadosCliente.nascimento,
            telefone = dadosCliente.telefone,
            email = dadosCliente.email,
            senha = dadosCliente.senha,
            cep = dadosCliente.cep,
            bairro = dadosCliente.bairro,
            complemento = dadosCliente.complemento
        )

        println(novoUsuario)

        val api = Apis.getApi()
        val chamada = api.postCliente(novoUsuario)
        chamada.enqueue(object : Callback<Cliente> {

            override fun onResponse(call: Call<Cliente>, response: Response<Cliente>) {
                val resposta = response.body()
                if (resposta != null) {
                    val tela = Intent(applicationContext, CadastroClienteConcluido::class.java)
                    startActivity(tela)
                } else {
                    println("Segundo else cliente")
                    println(resposta)
                }
            }

            override fun onFailure(call: Call<Cliente>, t: Throwable) {
                Toast.makeText(baseContext, "Erro na API: ${t.message}",
                    Toast.LENGTH_SHORT).show()
                t.printStackTrace()
            }
        })
    }
}
