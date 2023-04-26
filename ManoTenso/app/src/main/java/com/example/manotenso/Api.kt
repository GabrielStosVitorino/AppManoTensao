package com.example.manotenso

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    //                                  CLIENTE
    @POST("/clientes/autenticacao-cliente/{email}/{senha}")
    fun loginCliente(@Path("email") email: String, @Path("senha") senha: String): Call<Cliente>

    @DELETE("/clientes/logoff-cliente/{id}")
    fun logoffCliente(@Path("id") id: Int): Call<Void>

    @GET("/clientes")
    fun getClientes(): Call<List<Cliente>>

    @POST("/clientes")
    fun postCliente(@Body novoUsuario: Cliente): Call<Cliente>

    @DELETE("/clientes/{id}")
    fun deleteCliente(@Path("id") id: Int): Call<Void>

    @PUT("/clientes/{id}")
    fun putCliente(@Path("idCliente") id: Int, @Query("cliente") cliente: Cliente): Call<Cliente>

    fun lerArquivoTxtCliente(@Query("nomeArq") nomeArq: String): Call<CartaApresentacao>

    @PUT("/clientes/receber-apresentacao")
    fun apresentacaoCliente(
        @Query("idCliente") idCliente: Int,
        @Query("nomeArq") nomeArq: String
    ): Call<CartaApresentacao>

    //                              PRESTADOR

    @POST("/prestadores/autenticacao-prestador/{email}/{senha}")
    fun loginPrestador(
        @Path("email") email: String,
        @Path("senha") senha: String
    ): Call<Prestador>

    @DELETE("/prestadores/logoff-prestador/{id}")
    fun logoffPrestador(@Path("id") id: Int): Call<Void>

    @GET("/prestadores")
    fun getPrestadores(): Call<List<Prestador>>

    @GET("/prestadores/filtro-por-servico/{idServico}/{segundaVariacao}/{terceiraVariacao}/{quartaVariacao}")
    fun getPorServicoPrestador(
        @Path("idServico") idServico: Int,
        @Path("segundaVariacao") segundaVariacao: Int,
        @Path("terceiraVariacao") terceiraVariacao: Int,
        @Path("quartaVariacao") quartaVariacao: Int
    ): Call<List<FiltroPorAvaliacao>>

    @POST("/prestadores")
    fun postPrestador(@Body novoPrestador: Prestador): Call<Prestador>

    @DELETE("/prestadores/{id}")
    fun deletePrestador(@Path("id") id: Int): Call<Void>

    @PUT("/prestadores/{id}")
    fun putPrestador(
        @Path("id") id: Int,
        @Query("prestador") prestador: Prestador
    ): Call<Prestador>

    fun lerArquivoTxtPrestador(nomeArq: String): Call<CartaApresentacao>

    fun gerarBoletoPrestador(prestador: Prestador, nomeArq: String): Call<Void>

    fun gravaRegistroPrestador(registro: String, nomeArq: String?)

    @GET("/prestadores/carta-apresentacao/{idPrestador}")
    fun cartaApresentacaoPrestador(@Path("idPrestador") idPrestador: Int): Call<CartaApresentacao>

    @GET("/prestadores/gerar-boleto/{idPrestador}")
    fun boletoTxtPrestador(@Path("idPrestador") idPrestador: Int): Call<Prestador>

    @PUT("/prestadores/receber-apresentacao")
    fun apresentacaoPrestador(
        @Query("idPrestador") idPrestador: Int,
        @Query("nomeArq") nomeArq: String
    ): Call<CartaApresentacao>

    @GET("/prestadores/quantidade-propostas/{idPrestador}")
    fun getPropostasNoUltimoMesPrestador(@Path("idPrestador") idPrestador: Int): Call<Int>

    //                                 SERVICO

    @GET("/servicos")
    fun getServico(): Call<List<Servico>>

    @POST("/servicos")
    fun postServico(@Query("novoServico") novoServico: Servico?): Call<Servico>

    @DELETE("/servicos/{id}")
    fun deleteServicos(@Path("id") id: Int): Call<Void>

    @PUT("/servicos/{id}")
    fun putServico(@Path("id") id: Int, @Query("servico") servico: Servico): Call<Servico>


    //                                  PLANO

    @GET("/planos")
    fun getPlanos(): Call<List<Plano>>


    @POST("/planos")
    fun postPlanos(@Query("novoPlano") novoPlano: Plano): Call<Plano>

    @DELETE("/planos/{id}")
    fun deletePlanos(@Path("id") id: Int): Call<Void>

    @PUT("/planos/{id}")
    fun putPlanos(@Path("id") id: Int, plano: Plano): Call<Plano>

}