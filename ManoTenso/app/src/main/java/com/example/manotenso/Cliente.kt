package com.example.manotenso

data class Cliente(

    val idCliente: Int? = null,
    val nome: String? = null,
    val email: String?,
    val senha: String?,
    val telefone: String? = null,
    val cpf: String? = null,
    val dtNascimento: String? = null,
    val cep: String? = null,
    val bairro: String? = null,
    val rua: String? = null,
    val numero: Int? = null,
    val complemento: String? = null,
    val autenticado: Int? = null,
    val urlFoto: String? = null,
    val cartaApresentacao: String? = null
) {
    fun getEnderecoCompleto(): String {
        return "$rua $numero $bairro"
    }
}
