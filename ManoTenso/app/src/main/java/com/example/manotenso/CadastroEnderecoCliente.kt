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
        val nomeCompleto = intent.getStringExtra("nomeCompleto")
        val cpf = intent.getStringExtra("cpf")
        val nascimento = intent.getStringExtra("nascimento")
        val senha = intent.getStringExtra("senha")
        val email = intent.getStringExtra("email")
        val telefone = intent.getStringExtra("telefone")
    }

    fun cadastrarCliente(componente: View){

        val cep = findViewById<EditText>(R.id.et_cep).text.toString()
        val bairro = findViewById<EditText>(R.id.et_bairro).text.toString()
        val logradouro = findViewById<EditText>(R.id.et_logradouro).text.toString()
        val numero = findViewById<EditText>(R.id.et_numero).text.toString()
        val complemento = findViewById<EditText>(R.id.et_complemento).text.toString()

        val novoUsuario = Cliente (
            nome = intent.getStringExtra("nomeCompleto"),
            cpf = intent.getStringExtra("cpf"),
            dtNascimento = intent.getStringExtra("nascimento"),
            telefone = intent.getStringExtra("telefone"),
            email = intent.getStringExtra("email"),
            senha = intent.getStringExtra("senha"),
            cep = intent.getStringExtra("cep"),
            bairro = intent.getStringExtra("bairro"),
            complemento = intent.getStringExtra("complemento")
        )
        val api = Apis.getApi()
        val chamada = api.postCliente(novoUsuario)
        chamada.enqueue(object : Callback<Cliente> {

            override fun onResponse(call: Call<Cliente>, response: Response<Cliente>) {
                if (response.isSuccessful) {
                    val resposta = response.body()
                    if (resposta != null) {
                        val tela = Intent(applicationContext, CadastroClienteConcluido::class.java)
                        tela.putExtra("cep", cep)
                        tela.putExtra("bairro", bairro)
                        tela.putExtra("logradouro", logradouro)
                        tela.putExtra("numero", numero)
                        tela.putExtra("complemento", complemento)
                        startActivity(tela)
                    } else {

                    }
                } else {

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
