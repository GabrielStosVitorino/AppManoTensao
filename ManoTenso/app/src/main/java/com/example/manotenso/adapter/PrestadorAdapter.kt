package com.example.manotenso.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.example.manotenso.Prestador
import com.example.manotenso.R
import com.squareup.picasso.Picasso
import java.util.*

class PrestadorAdapter(val listaPrestador: MutableList<Prestador>,
                       private val onclick: (id: Int) -> Unit)
    : RecyclerView.Adapter<PrestadorAdapter.PrestadorViewHolder>() {

    private var btnltke:kotlin.Boolean = false

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PrestadorAdapter.PrestadorViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.prestador_item,
            parent, false
        )
        return PrestadorViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PrestadorAdapter.PrestadorViewHolder, position: Int) {
        (holder as PrestadorViewHolder).vincular(listaPrestador[position])
    }

    override fun getItemCount(): Int {
        return listaPrestador.size
    }
    inner class PrestadorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun vincular(prestador : Prestador) {
            val nomePrestador = itemView.findViewById<TextView>(R.id.tv_name)
            val fotoPrestador = itemView.findViewById<ImageView>(R.id.iv_prestador)
            val celulaPrestador = itemView.findViewById<RelativeLayout>(R.id.celula_prestador)
            val location = itemView.findViewById<TextView>(R.id.tv_location)
            var lottie = itemView.findViewById<LottieAnimationView>(R.id.animationView)

            nomePrestador.text = prestador.nome
            var urlFoto: String? = "https://filestore.community.support.microsoft.com/api/images/6061bd47-2818-4f2b-b04a-5a9ddb6f6467?upload=true&fud_access=wJJIheezUklbAN2ppeDns8cDNpYs3nCYjgitr%2BfFBh2dqlqMuW7np3F6Utp%2FKMltnRRYFtVjOMO5tpbpW9UyRAwvLeec5emAPixgq9ta07Dgnp2aq5eJbnfd%2FU3qhn5498QChOTHl3NpYS7xR7zASsaF20jo4ICSz2XTm%2B3GDR4XitSm7nHRR843ku7uXQ4oF6innoBxMaSe9UfrAdMi7owFKjdP9m1UP2W5KAtfQLNQqewpIgNm8TVO4GO5v9sGqgqs3xWAuztC7LdeU1uK5MlYEg4tcMW8ax1kJeEuI7GF14QRdq%2FnahToC7uRfuyqXfrNDVU7TRYmeyQhkHZT14xQvDhOtAZUQgwPgSV7MB43JrYAXNh8fJC6Ja0mJH8pVl6qWr%2F6VLaLsMefSMUp6P6zavS%2F%2F0ocUyQZKumNlok%3D"

            if (Objects.nonNull(prestador.urlFoto)) {
                urlFoto = prestador.urlFoto
            }

            Picasso.get().load(urlFoto).into(fotoPrestador)

            celulaPrestador.setOnClickListener {
                onclick(prestador.id!!)
            }
            lottie.setOnClickListener(View.OnClickListener {
                if (btnltke) {
                    lottie.playAnimation()
                    btnltke = false
                } else {
                    lottie.reverseAnimationSpeed()
                    btnltke = true
                }

            })
        }
    }
}