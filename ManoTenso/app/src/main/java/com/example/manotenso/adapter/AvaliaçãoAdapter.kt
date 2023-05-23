package com.example.manotenso.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.manotenso.*
import com.example.manotenso.SessaoUsuario.prestador
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class AvaliaçãoAdapter(val listaAvaliacao: MutableList<FiltroPorAvaliacao>,
                       private val onclick: (id: Int) -> Unit)
    : RecyclerView.Adapter<AvaliaçãoAdapter.AvaliacaPrestadorViewHolder>() {

    lateinit var distanciaService: DistanceMatrixService

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AvaliaçãoAdapter.AvaliacaPrestadorViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.prestador_item,
            parent, false
        )
        return AvaliacaPrestadorViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AvaliaçãoAdapter.AvaliacaPrestadorViewHolder, position: Int) {
        (holder as AvaliacaPrestadorViewHolder).vincular(listaAvaliacao[position])
    }

    override fun getItemCount(): Int {
        return listaAvaliacao.size
    }

    inner class AvaliacaPrestadorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun vincular(avaliacao: FiltroPorAvaliacao) {
            val nomePrestador = itemView.findViewById<TextView>(R.id.tv_name)
            val fotoPrestador = itemView.findViewById<ImageView>(R.id.iv_prestador)
            val celulaPrestador = itemView.findViewById<RelativeLayout>(R.id.celula_prestador)
            val location = itemView.findViewById<TextView>(R.id.tv_location)

            nomePrestador.text = avaliacao.nome
            var urlFoto: String? = "https://filestore.community.support.microsoft.com/api/images/6061bd47-2818-4f2b-b04a-5a9ddb6f6467?upload=true&fud_access=wJJIheezUklbAN2ppeDns8cDNpYs3nCYjgitr%2BfFBh2dqlqMuW7np3F6Utp%2FKMltnRRYFtVjOMO5tpbpW9UyRAwvLeec5emAPixgq9ta07Dgnp2aq5eJbnfd%2FU3qhn5498QChOTHl3NpYS7xR7zASsaF20jo4ICSz2XTm%2B3GDR4XitSm7nHRR843ku7uXQ4oF6innoBxMaSe9UfrAdMi7owFKjdP9m1UP2W5KAtfQLNQqewpIgNm8TVO4GO5v9sGqgqs3xWAuztC7LdeU1uK5MlYEg4tcMW8ax1kJeEuI7GF14QRdq%2FnahToC7uRfuyqXfrNDVU7TRYmeyQhkHZT14xQvDhOtAZUQgwPgSV7MB43JrYAXNh8fJC6Ja0mJH8pVl6qWr%2F6VLaLsMefSMUp6P6zavS%2F%2F0ocUyQZKumNlok%3D"

            if (Objects.nonNull(avaliacao.urlFoto)) {
                urlFoto = avaliacao.urlFoto
            }

            Picasso.get().load(urlFoto).into(fotoPrestador)

            prestador?.let {
                distanciaService.getDistance(SessaoUsuario.cliente!!.getEnderecoCompleto(), it.getEnderecoCompleto())
                    .enqueue(object : Callback<DistanceResponse> {
                        override fun onResponse(
                            call: Call<DistanceResponse>,
                            response: Response<DistanceResponse>
                        ) {
                            location.text = response.body()?.rows?.get(0)?.elements?.get(0)?.distance?.text
                        }

                        override fun onFailure(call: Call<DistanceResponse>, t: Throwable) {
                            t.printStackTrace()
                        }

                    })
            }

            celulaPrestador.setOnClickListener {
                onclick(prestador?.id!!)
            }
        }
    }
}