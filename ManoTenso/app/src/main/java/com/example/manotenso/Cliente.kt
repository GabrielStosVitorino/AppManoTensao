package com.example.manotenso

data class Cliente(

    var nome: String? = null,
    var email: String? = null,
    var senha: String? = null,
    var telefone: String? = null,
    var cpf: String? = null,
    var dtNascimento: String? = null,
    var cep: String? = null,
    var bairro: String? = null,
    var rua: String? = null,
    var numero: Int? = null,
    var complemento: String? = null,
    var autenticado: Int? = null,
    var urlFoto: String? = null,
    var cartaApresentacao: String? = null,
    var idCliente: Int? = null
): java.io.Serializable {
    fun getEnderecoCompleto(): String {
        return "$rua $numero $bairro"
    }
}
