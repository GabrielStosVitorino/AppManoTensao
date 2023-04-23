package com.example.manotenso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CadastroCliente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_cliente)
    }

    fun cadastrarCliente(){
        val novoUsuario = Cliente (
            email = "gabriel@bandtec.com.br",
            senha = "verdão"
        )
        val api = Apis.getApi()
        val chamada = api.postCliente(novoUsuario)
        chamada.enqueue(object : Callback<Cliente> {

            override fun onResponse(call: Call<Cliente>, response: Response<Cliente>) {
                if (response.isSuccessful) {
                    val resposta = response.body()
                    if (resposta != null) {

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