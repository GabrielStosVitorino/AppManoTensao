package com.example.manotenso

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeCliente : AppCompatActivity() {

    var items = arrayOf("Pintura", "Elétrica", "Hidráulica")
    var adapterItems: ArrayAdapter<String>? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home_cliente)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_menu, NavegacaoFragment(), "FRAGMENT_MENU")
        transaction.commit()

        var autoCompleteTxt = findViewById<AutoCompleteTextView>(R.id.auto_complete_txt)

        adapterItems = ArrayAdapter(this, R.layout.list_item, items)
        autoCompleteTxt.setAdapter(adapterItems)

        autoCompleteTxt.setOnItemClickListener(OnItemClickListener { parent, view, position, id ->
            val item = parent.getItemAtPosition(position).toString()
            Toast.makeText(applicationContext, "Item: $item", Toast.LENGTH_SHORT).show()
        })


    }
}