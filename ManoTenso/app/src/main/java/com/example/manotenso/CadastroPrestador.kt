package com.example.manotenso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CadastroPrestador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_prestador)
    }

    fun cadastrarPrestador(){
        val novoUsuario = DadosPrestador (
            email = "gabriel@bandtec.com.br",
            senha = "verdão"
        )
        val api = Apis.getApi()
        val chamada = api.postPrestador(novoUsuario)
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

    fun cadastroInfosPrestador(componente: View) {
        val tela = Intent(applicationContext, CadastroInfosPrestador::class.java)
        startActivity(tela)
    }

}