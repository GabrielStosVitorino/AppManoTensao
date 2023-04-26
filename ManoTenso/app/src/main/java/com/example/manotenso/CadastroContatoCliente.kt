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
    lateinit var dadosCliente: dadosCliente
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_contato_cliente)
        dadosCliente = intent?.getSerializableExtra("dadosCliente") as dadosCliente
    }

    fun recuperarDados() {
        dadosCliente = intent.getSerializableExtra("dadosCliente") as dadosCliente

    }

    fun cadastrarCliente(componente: View){
        val dadosCliente = intent.getSerializableExtra("dadosCliente") as dadosCliente

        val email = findViewById<EditText>(R.id.et_email).text.toString()
        println(email)
        val telefone = findViewById<EditText>(R.id.et_telefone).text.toString()
        println(telefone)

        val novoUsuario = Cliente (
            nome = dadosCliente.nomeCompleto,
            cpf = dadosCliente.cpf,
            dtNascimento = dadosCliente.nascimento,
            telefone = telefone,
            email = email,
            senha = dadosCliente.senha
        )

        val tela = Intent(applicationContext, CadastroClienteConcluido::class.java)
        println(novoUsuario)

        val api = Apis.getApi()
        val chamada = api.postCliente(novoUsuario)
        chamada.enqueue(object : Callback<Cliente> {

            override fun onResponse(call: Call<Cliente>, response: Response<Cliente>) {
                val resposta = response.body()
                if (resposta != null) {
                    startActivity(tela)
                } else {
                    println("Segundo else cliente")
                    println(resposta)
                    println(novoUsuario)
                }
            }

            override fun onFailure(call: Call<Cliente>, t: Throwable) {
                Toast.makeText(baseContext, "Erro na API: ${t.message}",
                    Toast.LENGTH_SHORT).show()
                t.printStackTrace()
            }
        })
    }

    fun cadastroEndereco(componente: View) {

        val email = findViewById<EditText>(R.id.et_email).text.toString()
        val telefone = findViewById<EditText>(R.id.et_telefone).text.toString()

        val dadosCliente = dadosCliente(email,telefone)

        val tela = Intent(applicationContext, CadastroEnderecoCliente::class.java)
        tela.putExtra("dadosCliente", dadosCliente)
        startActivity(tela)
    }
}