package com.example.manotenso

import java.io.Serializable

data class DadosCliente(
    var nomeCompleto: String,
    var cpf: String? = "",
    var nascimento: String? = null,
    var senha: String? = "",
    var email: String? = null,
    var telefone: String? = null,
    var cep: String? = null,
    var bairro: String? = null,
    var logradouro: String? = null,
    var numero: Int? = null,
    var complemento: String? = null
) : Serializable
