package com.example.manotenso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun cadastrar(){
        val usuario = "cliente"
        val email = "gabriel@bandtec.com.br" // Joao Oliveira
        val senha = "verdão" // joao123
        val api = Apis.getApi()

        if(usuario == "cliente"){
            val chamada = api.loginCliente(email, senha)

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
        } else if(usuario == "prestador"){
            val chamada = api.loginPrestador(email, senha)

            chamada.enqueue(object : Callback<Prestador> {

                override fun onResponse(call: Call<Prestador>, response: Response<Prestador>) {
                    if (response.isSuccessful) {
                        val resposta = response.body()
                        if (resposta != null) {

                        } else {

                        }
                    } else {

                    }
                }

                override fun onFailure(call: Call<Prestador>, t: Throwable) {
                    Toast.makeText(baseContext, "Erro na API: ${t.message}",
                        Toast.LENGTH_SHORT).show()
                    t.printStackTrace()
                }
            })
        }

    }

}