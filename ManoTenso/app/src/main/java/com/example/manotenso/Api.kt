package com.example.manotenso

import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface Api {

    //                                  CLIENTE
    @POST("/clientes/autenticacao-cliente/{email}/{senha}")
    fun loginCliente(@Query("email") email: String, @Query("senha") senha: String): Call<Cliente>

    @DELETE("/clientes/logoff-cliente/{id}")
    fun logoffCliente(@Query("id") id: Int): Call<Void>

    @GET("/clientes")
    fun getClientes(): Call<List<Cliente>>

    @POST("/clientes")
    fun postCliente(novoUsuario: Cliente): Call<Cliente>

    @DELETE("/clientes/{id}")
    fun deleteCliente(@Query("id") id: Int): Call<Void>

    @PUT("/clientes/{id}")
    fun putCliente(@Query("idCliente") id: Int, @Query("cliente") cliente: Cliente): Call<Cliente>

    fun lerArquivoTxtCliente(@Query("nomeArq") nomeArq: String): Call<CartaApresentacao>

    @PUT("/clientes/receber-apresentacao")
    fun apresentacaoCliente(
        @Query("idCliente") idCliente: Int,
        @Query("nomeArq") nomeArq: String
    ): Call<CartaApresentacao>

    //                              PRESTADOR

    @POST("/prestadores/autenticacao-prestador/{email}/{senha}")
    fun loginPrestador(
        @Query("email") email: String,
        @Query("senha") senha: String
    ): Call<Prestador>

    @DELETE("/prestadores/logoff-prestador/{id}")
    fun logoffPrestador(@Query("id") id: Int): Call<Void>

    @GET("/prestadores")
    fun getPrestadores(): Call<List<Prestador>>

    @GET("/prestadores/filtro-por-servico/{idServico}/{segundaVariacao}/{terceiraVariacao}/{quartaVariacao}")
    fun getPorServicoPrestador(
        @Query("idServico") idServico: Int,
        @Query("segundaVariacao") segundaVariacao: Int,
        @Query("terceiraVariacao") terceiraVariacao: Int,
        @Query("quartaVariacao") quartaVariacao: Int
    ): Call<List<FiltroPorAvaliacao>>

    @POST("/prestadores")
    fun postPrestador(@Query("novoPrestador") novoPrestador: Prestador): Call<Prestador>

    @DELETE("/prestadores/{id}")
    fun deletePrestador(@Query("id") id: Int): Call<Void>

    @PUT("/prestadores/{id}")
    fun putPrestador(
        @Query("id") id: Int,
        prestador: Prestador
    ): Call<Prestador>

    fun lerArquivoTxtPrestador(nomeArq: String): Call<CartaApresentacao>

    fun gerarBoletoPrestador(prestador: Prestador, nomeArq: String): Call<Void>

    fun gravaRegistroPrestador(registro: String, nomeArq: String?)

    @GET("/prestadores/carta-apresentacao/{idPrestador}")
    fun cartaApresentacaoPrestador(@Query("idPrestador") idPrestador: Int): Call<CartaApresentacao>

    @GET("/prestadores/gerar-boleto/{idPrestador}")
    fun boletoTxtPrestador(@Query("idPrestador") idPrestador: Int): Call<Prestador>

    @PUT("/prestadores/receber-apresentacao")
    fun apresentacaoPrestador(
        idPrestador: Int,
        nomeArq: String
    ): Call<CartaApresentacao>

    @GET("/prestadores/quantidade-propostas/{idPrestador}")
    fun getPropostasNoUltimoMesPrestador(@Query("idPrestador") idPrestador: Int): Call<Int>

    //                                 SERVICO

    @GET("/servicos")
    fun getServico(): Call<List<Servico>>

    @POST("/servicos")
    fun postServico(novoServico: Servico?): Call<Servico>

    @DELETE("/servicos/{id}")
    fun deleteServicos(@Query("id") id: Int): Call<Void>

    @PUT("/servicos/{id}")
    fun putServico(@Query("id") id: Int, servico: Servico): Call<Servico>


    //                                  PLANO

    @GET("/planos")
    fun getPlanos(): Call<List<Plano>>


    @POST("/planos")
    fun postPlanos(novoPlano: Plano): Call<Plano>

    @DELETE("/planos/{id}")
    fun deletePlanos(@Query("id") id: Int): Call<Void>

    @PUT("/planos/{id}")
    fun putPlanos(@Query("id") id: Int, plano: Plano): Call<Plano>

}