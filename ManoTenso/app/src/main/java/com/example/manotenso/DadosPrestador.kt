package com.example.manotenso

data class DadosPrestador(
    var nome: String? = null,
    var cnpj: String? = null,
    var dtNascimento: String? = null,
    var senha: String? = null,
    var email :String? = null,
    var telefone: String? = null,
    var cep: String? = null,
    var bairro: String? = null,
    var rua: String? = null,
    var numero: Int? = null,
    var complemento: String? = null,
    var autenticado: Int? = null,
    var cartaApresentacao: String? = null
) : java.io.Serializable