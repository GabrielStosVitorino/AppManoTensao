package com.example.manotenso

import java.time.ZonedDateTime

data class Prestador(

    val idPrestador: Int? = null,
    val nome: String? = null,
    val email :String,
    val senha: String,
    val telefone: String? = null,
    val cpf: String? = null,
    val dtNascimento: ZonedDateTime? = null,
    val cep: String? = null,
    val bairro: String? = null,
    val rua: String? = null,
    val numero: Int? = null,
    val complemento: String? = null,
    val autenticado: Int? = null,
    val urlFoto: String? = null,
    val cartaApresentacao: String? = null,
    val idPrestadorval: Int? = null,
    val linkWhatsappval: String? = null,
    val fkServicoval: Servico? = null,
    val fkPlano: Plano? = null
)