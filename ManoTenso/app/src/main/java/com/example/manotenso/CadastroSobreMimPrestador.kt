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

class CadastroSobreMimPrestador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_sobre_mim_prestador)
    }

    fun cadastrarPrestador(componente: View){
        val dadosPrestador = intent.getSerializableExtra("dadosPrestadores") as DadosPrestador

        val sobreMim = findViewById<EditText>(R.id.et_sobre_mim).text.toString()

        dadosPrestador.cartaApresentacao = sobreMim

        val tela = Intent(applicationContext, CadastroPrestadorConcluido::class.java)

        val api = Apis.getApi()
        val chamada = api.postPrestador(dadosPrestador)
        chamada.enqueue(object : Callback<Prestador> {
            override fun onResponse(call: Call<Prestador>, response: Response<Prestador>) {
                val resposta = response.body()
                if (resposta != null) {
                    startActivity(tela)
                } else {
                    println("Segundo else cliente")
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