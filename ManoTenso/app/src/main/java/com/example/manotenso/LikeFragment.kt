package com.example.manotenso

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.manotenso.adapter.AvaliaçãoAdapter
import com.example.manotenso.adapter.PrestadorAdapter
import com.example.manotenso.databinding.FragmentLikeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LikeFragment : Fragment() {
    lateinit var prestadorAdapter: AvaliaçãoAdapter

    private val binding by lazy {
        FragmentLikeBinding.inflate(layoutInflater)
    }

    private val retrofit by lazy {
        Apis.getApi().getFiltroAvaliacao()
    }

    private val listaPrestador = mutableListOf<FiltroPorAvaliacao>()

    fun carregarListaApi() {

        retrofit.enqueue(object : Callback<List<FiltroPorAvaliacao>> {
            override fun onResponse(
                call: Call<List<FiltroPorAvaliacao>>,
                response: Response<List<FiltroPorAvaliacao>>
            ) {
                if (response.isSuccessful && !response.body()!!.isNullOrEmpty()) {
                    listaPrestador.addAll(response.body()!!)
                    prestadorAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<FiltroPorAvaliacao>>, t: Throwable) {
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

    private fun buscarPrestadorPorId(id: Int): FiltroPorAvaliacao? {
        return listaPrestador.find { prestador -> prestador.id == id }
    }

    fun exibeToast(id: Int) {
        val prestador = buscarPrestadorPorId(id)
        if (prestador != null) {
            val tela = Intent(context, Profile::class.java)
            tela.putExtra("prestadorNome", prestador.nome)
            tela.putExtra("prestadorFoto", prestador.urlFoto)
            startActivity(tela)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val prestadorRV = binding.rvPrestador

        prestadorAdapter = AvaliaçãoAdapter(listaPrestador) {
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