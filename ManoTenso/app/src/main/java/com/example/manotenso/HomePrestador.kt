package com.example.manotenso

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.manotenso.adapter.ClienteAdapter
import com.example.manotenso.databinding.FragmentHomePrestadorBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePrestador : Fragment() {

    lateinit var clienteAdapter: ClienteAdapter

    private val binding by lazy {
        FragmentHomePrestadorBinding.inflate(layoutInflater)
    }

    private val getCliente by lazy {
        Apis.getApi().getClientes()
    }

    private var listaCliente = mutableListOf<Cliente>()

    fun carregarListaApi() {

        getCliente.enqueue(object : Callback<List<Cliente>> {
            override fun onResponse(
                call: Call<List<Cliente>>,
                response: Response<List<Cliente>>
            ) {
                if (response.isSuccessful && !response.body()!!.isNullOrEmpty()) {
                    listaCliente.addAll(response.body()!!)
                    clienteAdapter.notifyDataSetChanged()
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    private fun buscarClientePorId(id: Int): Cliente? {
        return listaCliente.find { cliente -> cliente.idCliente == id }
    }


    // pode jogar pra uma tela
    fun exibeToast(id: Int) {
        val cliente = buscarClientePorId(id)
        if (cliente != null) {
            val tela = Intent(context, Profile::class.java)
            tela.putExtra("prestadorNome", cliente.nome)
            tela.putExtra("prestadorDescricao", cliente.cartaApresentacao)
            tela.putExtra("prestadorFoto", cliente.urlFoto)
            startActivity(tela)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val clienteRV = binding.rvCliente

        clienteAdapter = ClienteAdapter(listaCliente) {
                mensagem -> exibeToast(mensagem)
        }
        clienteAdapter.distanciaService = Apis.getDistanceMatrix()

        val layoutManager = LinearLayoutManager(view.context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        clienteRV.layoutManager = layoutManager
        clienteRV.adapter = clienteAdapter

        carregarListaApi()

        clienteAdapter.notifyDataSetChanged()
        clienteRV.itemAnimator = null
    }
}