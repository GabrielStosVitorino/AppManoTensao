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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_endereco_cliente)
    }

    fun cadastrarCliente(componente: View){
        val dadosCliente = intent.getSerializableExtra("dadosCliente") as DadosCliente

        val cep = findViewById<EditText>(R.id.et_cep).text.toString()
        val bairro = findViewById<EditText>(R.id.et_bairro).text.toString()
        val logradouro = findViewById<EditText>(R.id.et_logradouro).text.toString()
        val numero = findViewById<EditText>(R.id.et_numero).text.toString().toInt()
        val complemento = findViewById<EditText>(R.id.et_complemento).text.toString()

        dadosCliente.cep = cep
        dadosCliente.bairro = bairro
        dadosCliente.logradouro = logradouro
        dadosCliente.numero = numero
        dadosCliente.complemento = complemento

        println(dadosCliente)

        val api = Apis.getApi()
        val chamada = api.postCliente(dadosCliente)
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
