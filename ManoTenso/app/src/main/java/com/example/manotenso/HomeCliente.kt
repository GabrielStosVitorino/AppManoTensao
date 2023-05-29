package com.example.manotenso

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.manotenso.adapter.PrestadorAdapter
import com.example.manotenso.databinding.FragmentHomeClienteBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeCliente : Fragment() {

    lateinit var prestadorAdapter: PrestadorAdapter

    private val binding by lazy {
        FragmentHomeClienteBinding.inflate(layoutInflater)
    }

    private val retrofit by lazy {
        Apis.getApi().getPrestadores()
    }

    private val listaPrestador = mutableListOf<Prestador>()

    fun carregarListaApi() {

        retrofit.enqueue(object : Callback<List<Prestador>> {
            override fun onResponse(
                call: Call<List<Prestador>>,
                response: Response<List<Prestador>>
            ) {
                if (response.isSuccessful && !response.body()!!.isNullOrEmpty()) {
                    listaPrestador.addAll(response.body()!!)
                    prestadorAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<Prestador>>, t: Throwable) {
                t.printStackTrace()
                Toast.makeText(
                    context,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }

        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    private fun buscarPrestadorPorId(id: Int): Prestador? {
        return listaPrestador.find { prestador -> prestador.id == id }
    }


    // pode jogar pra uma tela
    fun exibeToast(id: Int) {
        val prestador = buscarPrestadorPorId(id)
        if (prestador != null) {
            val tela = Intent(context, Profile::class.java)
            tela.putExtra("prestadorNome", prestador.nome)
            tela.putExtra("prestadorDescricao", prestador.cartaApresentacao)
            tela.putExtra("prestadorFoto", prestador.urlFoto)
            tela.putExtra("prestadorLinkWhatsapp", prestador.linkWhatsapp)
            startActivity(tela)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val prestadorRV = binding.rvPrestador

        prestadorAdapter = PrestadorAdapter(listaPrestador) {
                mensagem -> exibeToast(mensagem)
        }
        prestadorAdapter.distanciaService = Apis.getDistanceMatrix()

        val layoutManager = LinearLayoutManager(view.context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        prestadorRV.layoutManager = layoutManager
        prestadorRV.adapter = prestadorAdapter

        carregarListaApi()

        prestadorAdapter.notifyDataSetChanged()
    }
}