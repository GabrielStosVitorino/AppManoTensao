package com.example.manotenso

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.manotenso.adapter.PrestadorAdapter
import com.example.manotenso.databinding.FragmentHomeClienteBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePrestador : Fragment() {
    lateinit var prestadorAdapter: PrestadorAdapter

    private val binding by lazy {
        FragmentHomeClienteBinding.inflate(layoutInflater)
    }

    private val getPrestadores by lazy {
        Apis.getApi().getPrestadores()
    }

    private val getServicos by lazy {
        Apis.getApi().getServicos()
    }

    lateinit var adapterItems: ArrayAdapter<String>

    private var listaPrestador = mutableListOf<Prestador>()
    private val listaPrestadorTodos = mutableListOf<Prestador>()
    private val listaServicos = mutableListOf<Servico>()

    fun carregarListaApi() {

        getPrestadores.enqueue(object : Callback<List<Prestador>> {
            override fun onResponse(
                call: Call<List<Prestador>>,
                response: Response<List<Prestador>>
            ) {
                if (response.isSuccessful && !response.body()!!.isNullOrEmpty()) {
                    listaPrestadorTodos.addAll(response.body()!!)
                    listaPrestador.addAll(listaPrestadorTodos)
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


        getServicos.enqueue(object : Callback<List<Servico>> {
            override fun onResponse(
                call: Call<List<Servico>>,
                response: Response<List<Servico>>
            ) {
                if (response.isSuccessful && response.body()!!.isNotEmpty()) {
                    var autoCompleteTxt = binding.autoCompleteTxt

                    listaServicos.addAll(response.body()!!)
                    adapterItems = ArrayAdapter(activity!!.baseContext, R.layout.list_item, response.body()!!.map { it.tipoServico })
                    autoCompleteTxt.setAdapter(adapterItems)

                    autoCompleteTxt.onItemClickListener =
                        AdapterView.OnItemClickListener { parent, view, position, id ->

                            listaPrestador.clear()

                            listaPrestador.addAll(listaPrestadorTodos.filter {
                                it.fkServico != null &&  it.fkServico!!.idTipoServico ==  listaServicos.get(position).idTipoServico})


                            prestadorAdapter.notifyDataSetChanged()
                        }
                }
            }

            override fun onFailure(call: Call<List<Servico>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        });
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
        prestadorRV.itemAnimator = null
    }
}