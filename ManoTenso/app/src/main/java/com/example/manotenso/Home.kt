package com.example.manotenso

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.manotenso.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {

    private val binding by lazy {
        println(layoutInflater)
        ActivityHomeBinding.inflate(layoutInflater)
    }

    private val navController by lazy {
        (supportFragmentManager
            .findFragmentById(binding.fragmentPrest.id) as NavHostFragment)
            .navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_menu, NavegacaoFragment(), "FRAGMENT_MENU")
        transaction.commit()
    }
}