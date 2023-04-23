package com.example.manotenso

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("usuarios")
    fun getTodos() : Call<List<Usuario>>

    @GET("usuarios")
    fun getPorLoginSenha(@Query("login_senha") loginSenha: String) : Call<List<Usuario>>

    ////////////////////////////cliente///////////////////////////
    @POST("/autenticacao-cliente/{email}/{senha}")
    fun login(@Query("email") email: String, @Query("senha") senha: String){
    }

    @DELETE("/logoff-cliente/{id}")
    fun logoff(@Query id: Int): ResponseEntity<Void?>? {
    }

    @GET
    fun get(): ResponseEntity<List<Cliente?>?>? {
    }

    @POST
    fun post() {
    }

    @DELETE("/{id}")
    fun delete(@Query("idCliente") id: Int) {
    }

    @PUT("/{id}")
    fun put(@Query("idCliente") id: Int, @RequestBody cliente: Cliente) {
    }

    fun lerArquivoTxt(nomeArq: String?): CartaApresentacao? {
    }

    @PUT("/receber-apresentacao")
    fun apresentacao() {

    }

    ////////////////////////////prestador///////////////////////////

    @POST("/autenticacao-prestador/{email}/{senha}")
    fun login(
        @QUERY("email") email: String?,
        @QUERY("senha") senha: String?
    ){
    }

    @DELETE("/logoff-prestador/{id}")
    fun logoff(@QUERY id: Int){
    }

    @GET
    fun get(){
    }

    @GET("/filtro-por-servico/{idServico}/{segundaVariacao}/{terceiraVariacao}/{quartaVariacao}")
    operator fun get(
        @QUERY idServico: Int, @QUERY segundaVariacao: Int,
        @QUERY terceiraVariacao: Int, @QUERY quartaVariacao: Int
    ){
    }

    @POST
    fun post(@RequestBody novoPrestador: PrestadorServico) {
    }

    @DELETE("/{id}")
    fun delete(@QUERY id: Int){
    }

    @PUT("/{id}")
    fun put(
        @QUERY id: Int,
        @RequestBody prestador: PrestadorServico
    ){
    }

    fun lerArquivoTxt(nomeArq: String?): CartaApresentacao? {
        System.out.println("Achei o arquivo!")
    }

    fun gerarBoleto(prestador: PrestadorServico, nomeArq: String?) {
    }

    fun gravaRegistro(registro: String, nomeArq: String?) {
    }

    @GET("/carta-apresentacao/{idPrestador}")
    fun cartaApresentacao(@QUERY idPrestador: Int) {
    }

    @GET("/gerar-boleto/{idPrestador}")
    fun boletoTxt(@QUERY idPrestador: Int){
    }

    @PUT("/receber-apresentacao")
    fun apresentacao(
        @RequestParam idPrestador: Int,
        @RequestParam nomeArq: String?
    ): ResponseEntity<CartaApresentacao?>? {
    }

    @GET("/quantidade-propostas/{idPrestador}")
    fun getPropostasNoUltimoMes(@QUERY idPrestador: Int) {
    }



    ////////////////////////////servico///////////////////////////

    @GET
    fun get(){

    }

    @POST
    fun post(@RequestBody novoServico: Servico?) {
    }

    @DELETE("/{id}")
    fun delete(@PathVariable id: Int) {
    }

    @PUT("/{id}")
    fun put(@PathVariable id: Int, @RequestBody servico: Servico){
    }


    ////////////////////////////plano///////////////////////////

    @GET
    fun get() {
    }


    @POST
    fun post(@RequestBody novoPlano: Plano?) {
    }

    @DELETE("/{id}")
    fun delete(@PathVariable id: Int) {
    }

    @PUT("/{id}")
    fun put(@PathVariable id: Int, @RequestBody plano: Plano) {

}