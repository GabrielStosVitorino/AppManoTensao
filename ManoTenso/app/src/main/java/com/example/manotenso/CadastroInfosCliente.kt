package com.example.manotenso

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.EditText
import com.example.manotenso.databinding.ActivityCadastroInfosClienteBinding
import com.squareup.picasso.Picasso

class CadastroInfosCliente : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroInfosClienteBinding
    private val REQUEST_IMAGE_GALLERY = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroInfosClienteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListeners()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_IMAGE_GALLERY && resultCode == RESULT_OK && data != null) {
            val imageUri = data.data
            exibirImagemSelecionada(imageUri!!)
        }
    }

    private fun setupListeners() {
        binding.btnPerfil.setOnClickListener {
            abrirGaleria()
        }
    }

    private fun abrirGaleria() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, REQUEST_IMAGE_GALLERY)
    }

   fun cadastroContato(componente: View) {
        val nomeCompleto = binding.etNomeCompleto.text.toString()
        val cpf = binding.etCpf.text.toString()
        val nascimento = binding.etDataNascimento.text.toString()
        val senha = binding.etCrieSenha.text.toString()

        val dadosCliente = Cliente()

       dadosCliente.nome = nomeCompleto
       dadosCliente.cpf = cpf
       dadosCliente.dtNascimento = nascimento
       dadosCliente.senha = senha
       val fotoUri = binding.ivEllipse.tag as Uri?
       val fotoUrl = "${fotoUri!!.path!!.replace("content","file").replace("/-1/1/","")}"

       dadosCliente.urlFoto = fotoUrl
        val tela = Intent(applicationContext, CadastroContatoCliente::class.java)
        tela.putExtra("dadosCliente", dadosCliente)
        startActivity(tela)
    }

    private fun exibirImagemSelecionada(imageUri: Uri) {
        Picasso.get()
            .load(imageUri)
            .into(binding.ivEllipse)

        binding.ivEllipse.tag = imageUri
    }
}