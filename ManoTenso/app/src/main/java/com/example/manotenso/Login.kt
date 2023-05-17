package com.example.manotenso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {

    private lateinit var googleSignInt: Button
    private lateinit var gso: GoogleSignInOptions
    private lateinit var gsc: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        googleSignInt = findViewById(R.id.btn_google)
        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        gsc = GoogleSignIn.getClient(this, gso)

        val account: GoogleSignInAccount? = GoogleSignIn.getLastSignedInAccount(this)

        if (account != null) {
            goToHome()
        }

        googleSignInt.setOnClickListener {
            goToSignIn()
        }

    }

    private fun goToSignIn() {
        val signInIntent = gsc.signInIntent
        startActivityForResult(signInIntent, 1000)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1000) {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                task.getResult(ApiException::class.java)
                goToHome()

            } catch (e:java.lang.Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun goToHome() {
        val telaLoginCliente = Intent(applicationContext, HomeCliente::class.java)
        startActivity(telaLoginCliente)
    }

    fun logar(componente: View){
        val email = findViewById<EditText>(R.id.et_input_email).text.toString()
        val senha = findViewById<EditText>(R.id.et_input_senha).text.toString()
        val checkBox = findViewById<CheckBox>(R.id.cb_e_prestador).isChecked()
        val api = Apis.getApi()

        if(!checkBox){
            val chamada = api.loginCliente(email, senha)

            chamada.enqueue(object : Callback<Cliente> {

                override fun onResponse(call: Call<Cliente>, response: Response<Cliente>) {
                    val resposta = response.body()
                    if (resposta != null) {
                        goToHome()
                    } else {
                        println("segundo else cliente")
                        println(resposta)
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