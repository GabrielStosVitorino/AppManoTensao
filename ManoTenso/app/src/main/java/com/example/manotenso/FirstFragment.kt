package com.example.manotenso

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.manotenso.databinding.FragmentHomeClienteBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentHomeClienteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeClienteBinding.inflate(inflater)
        return binding.root
    }

}