package com.example.manotenso

data class dadosPrestador(
    val nome: String? = null,
    val cnpj: String? = null,
    val dtNascimento: String? = null,
    val senha: String? = null,
    val email :String? = null,
    val telefone: String? = null,
    val cep: String? = null,
    val bairro: String? = null,
    val rua: String? = null,
    val numero: Int? = null,
    val complemento: String? = null,
    val autenticado: Int? = null,
    val cartaApresentacao: String? = null
) : java.io.Serializable