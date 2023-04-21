package com.example.manotenso

import java.time.ZonedDateTime

data class Cliente(

    val idCliente: Int,
    val nome: String,
    val email :String,
    val senha: String,
    val telefone: String,
    val cpf: String,
    val dtNascimento: ZonedDateTime,
    val cep: String,
    val bairro: String,
    val rua: String,
    val numero: Int,
    val complemento: String,
    val autenticado: Int,
    val urlFoto: String,
    val cartaApresentacao: String
)
