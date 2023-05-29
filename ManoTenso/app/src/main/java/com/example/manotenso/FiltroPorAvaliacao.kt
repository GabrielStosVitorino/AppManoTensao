package com.example.manotenso

data class FiltroPorAvaliacao(
    val nome : String,
    val email : String,
    val urlFoto : String,
    val telefone : String,
    val media : Double,
    val cep : String,
    val rua: String,
    val bairro: String,
    val numero: Int,
    val id: Int
) {
    fun getEnderecoCompleto(): String {
        return "$rua $numero $bairro"
    }
}
