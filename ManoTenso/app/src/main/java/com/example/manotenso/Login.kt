package com.example.manotenso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun logar(componente: View){
        val email = findViewById<EditText>(R.id.et_input_email).text.toString() // Joao Oliveira
        val senha = findViewById<EditText>(R.id.et_input_senha).text.toString() // joao123
        val checkBox = findViewById<CheckBox>(R.id.cb_e_prestador).isChecked()
        val api = Apis.getApi()

        if(!checkBox){
            val chamada = api.loginCliente(email, senha)

            chamada.enqueue(object : Callback<Cliente> {

                override fun onResponse(call: Call<Cliente>, response: Response<Cliente>) {
                    val resposta = response.body()
                    if (resposta != null) {
                        val telaLoginCliente = Intent(applicationContext, HomeCliente::class.java)
                        startActivity(telaLoginCliente)
                    } else {
                        println("segundo else cliente")
                    }
                }

                override fun onFailure(call: Call<Cliente>, t: Throwable) {
                    Toast.makeText(baseContext, "Erro na API: ${t.message}",
                        Toast.LENGTH_SHORT).show()
                    t.printStackTrace()
                }
            })
        } else if(checkBox){
            val chamada = api.loginPrestador(email, senha)

            chamada.enqueue(object : Callback<Prestador> {

                override fun onResponse(call: Call<Prestador>, response: Response<Prestador>) {
                    val resposta = response.body()
                    if (resposta != null) {
                        val telaLoginPrestador = Intent(applicationContext, HomePrestador::class.java)
                        startActivity(telaLoginPrestador)
                    } else {
                        println("segundo else prestador")
                        println(resposta)
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

    fun cadastro(componente: View) {
        val telaCadastro = Intent(applicationContext, Cadastro::class.java)
        startActivity(telaCadastro)
    }

}