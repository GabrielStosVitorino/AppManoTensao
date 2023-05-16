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

    // pode jogar pra uma tela
    fun exibeToast(id: Int) {
        val tela = Intent(context, Profile::class.java)
        tela.putExtra("id", id)
        startActivity(tela)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val prestadorRV = binding.rvPrestador

        prestadorAdapter = PrestadorAdapter(listaPrestador) {
                mensagem -> exibeToast(mensagem)

        }

        val layoutManager = LinearLayoutManager(view.context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        prestadorRV.layoutManager = layoutManager
        prestadorRV.adapter = prestadorAdapter

//        carregarListaApi()

        listaPrestador.addAll(
            mutableListOf<Prestador>(
                Prestador(
                    90,
                    "bbbbbb",
                    "test_4adc793856a0",
                    "test_391fcf7fbe38",
                    "test_dfb2652c1631",
                    "test_04415e26cc80",
                    "test_faded3f6ae03",
                    "test_25f53c48b72f",
                    "test_82474453f9d1",
                    "test_0639b4e15137",
                    49,
                    "test_1272d47a2806",
                    76,
                    "https://img.freepik.com/fotos-gratis/empresaria-confiante-sorridente-posando-com-os-bracos-cruzados_1262-20950.jpg?size=626&ext=jpg&ga=GA1.2.1225098191.1683057949&semt=sph",
                    "test_1e62aab4e3a3",
                    "test_dfd259219973",
                    null,
                    null
                ),
                Prestador(
                    91,
                    "aaaaaaa",
                    "test_4adc793856a0",
                    "test_391fcf7fbe38",
                    "test_dfb2652c1631",
                    "test_04415e26cc80",
                    "test_faded3f6ae03",
                    "test_25f53c48b72f",
                    "test_82474453f9d1",
                    "test_0639b4e15137",
                    49,
                    "test_1272d47a2806",
                    76,
                    null,
                    "test_1e62aab4e3a3",
                    "test_dfd259219973",
                    null,
                    null
                ),
                Prestador(
                    92,
                    "cccccccccc",
                    "test_4adc793856a0",
                    "test_391fcf7fbe38",
                    "test_dfb2652c1631",
                    "test_04415e26cc80",
                    "test_faded3f6ae03",
                    "test_25f53c48b72f",
                    "test_82474453f9d1",
                    "test_0639b4e15137",
                    49,
                    "test_1272d47a2806",
                    76,
                    null,
                    "test_1e62aab4e3a3",
                    "test_dfd259219973",
                    null,
                    null
                )
            )
        )

        prestadorAdapter.notifyDataSetChanged()


    }
}