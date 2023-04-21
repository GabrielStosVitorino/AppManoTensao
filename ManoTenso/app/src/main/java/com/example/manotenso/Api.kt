package com.example.manotenso

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("usuarios")
    fun getTodos() : Call<List<Usuario>>

    @GET("usuarios")
    fun getPorLoginSenha(@Query("login_senha") loginSenha: String) : Call<List<Usuario>>
    
}