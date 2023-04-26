package com.example.manotenso

import java.io.Serializable
import java.time.LocalDate

data class dadosCliente(
    val nomeCompleto: String,
    val cpf: String? = "",
    val nascimento: LocalDate? = null,
    val senha: String? = "",
    val email: String? = null,
    val telefone: String? = null,
    val cep: String? = null,
    val bairro: String? = null,
    val logradouro: String? = null,
    val numero: Int? = null,
    val complemento: String? = null
) : Serializable
