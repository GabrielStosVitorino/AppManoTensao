package com.example.manotenso

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.manotenso.databinding.FragmentPerfilBinding
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class Perfil : Fragment() {

    lateinit var cliente: Cliente

    private val binding by lazy {
        FragmentPerfilBinding.inflate(layoutInflater)
    }

    private val retrofit by lazy {
        Apis.getApi().getClientes()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        obterDadosUsuario()
    }

    private fun obterDadosUsuario() {
        retrofit.enqueue(object : Callback<List<Cliente>> {
            override fun onResponse(
                call: Call<List<Cliente>>,
                response: Response<List<Cliente>>
            ) {
                if (response.isSuccessful) {
                    val clientes = response.body()
                    if (!clientes.isNullOrEmpty()) {
                        val cliente = clientes[0]
                        this@Perfil.cliente = cliente
                        exibirInformacoesPerfil(cliente)
                    }
                }
            }

            override fun onFailure(call: Call<List<Cliente>>, t: Throwable) {
                t.printStackTrace()
                Toast.makeText(
                    context,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun exibirInformacoesPerfil(cliente: Cliente) {
        binding.tvNome.text = cliente.nome
        binding.tvDescricao.text = cliente.cartaApresentacao
        val fotoPrestador = binding.ivPhoto

        var urlFoto: String? =
            "https://filestore.community.support.microsoft.com/api/images/6061bd47-2818-4f2b-b04a-5a9ddb6f6467?upload=true&fud_access=wJJIheezUklbAN2ppeDns8cDNpYs3nCYjgitr%2BfFBh2dqlqMuW7np3F6Utp%2FKMltnRRYFtVjOMO5tpbpW9UyRAwvLeec5emAPixgq9ta07Dgnp2aq5eJbnfd%2FU3qhn5498QChOTHl3NpYS7xR7zASsaF20jo4ICSz2XTm%2B3GDR4XitSm7nHRR843ku7uXQ4oF6innoBxMaSe9UfrAdMi7owFKjdP9m1UP2W5KAtfQLNQqewpIgNm8TVO4GO5v9sGqgqs3xWAuztC7LdeU1uK5MlYEg4tcMW8ax1kJeEuI7GF14QRdq%2FnahToC7uRfuyqXfrNDVU7TRYmeyQhkHZT14xQvDhOtAZUQgwPgSV7MB43JrYAXNh8fJC6Ja0mJH8pVl6qWr%2F6VLaLsMefSMUp6P6zavS%2F%2F0ocUyQZKumNlok%3D"

        if (Objects.nonNull(cliente.urlFoto)) {
            urlFoto = cliente.urlFoto
        }

        Picasso.get().load(urlFoto).into(fotoPrestador)
    }
}