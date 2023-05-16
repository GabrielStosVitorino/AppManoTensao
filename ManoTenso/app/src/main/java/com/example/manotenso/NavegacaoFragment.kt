package com.example.manotenso

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.manotenso.databinding.FragmentNavegacaoBinding

class NavegacaoFragment: Fragment() {
    private lateinit var binding: FragmentNavegacaoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNavegacaoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        chamadaFragment(HomeCliente(), "FRAGMENT_HOME")

        binding.ivSearch.setOnClickListener {
            chamadaFragment(HomeCliente(), "FRAGMENT_HOME")
        }

        binding.ivHeart.setOnClickListener {
            chamadaFragment(LikeFragment(), "FRAGMENT_LIKE")
        }

        binding.ivProfile.setOnClickListener {
            chamadaFragment(Perfil(), "FRAGMENT_PROFILE")
        }

    }

    fun chamadaFragment(fragment: Fragment, tag: String) {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction!!.replace(R.id.fragment_prest, fragment, tag)
        transaction.commit()
    }
}