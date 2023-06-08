package com.example.manotenso

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

object Apis {
    var BASE_URL_BACK = "https://23.21.241.160:8090/"
    var BASE_URL_DISTANCE_MATRIX = "https://maps.googleapis.com"

    fun getApi(): Api {
        val cliente = createUnsafeRetrofit()
        return cliente.create(Api::class.java)
    }

    fun getDistanceMatrix(): DistanceMatrixService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL_DISTANCE_MATRIX)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(DistanceMatrixService::class.java)
    }

    fun createUnsafeRetrofit(): Retrofit {
        val client = createUnsafeOkHttpClient()

        return Retrofit.Builder()
            .baseUrl(BASE_URL_BACK) // URL base da API
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun createUnsafeOkHttpClient(): OkHttpClient {
        // Cria um TrustManager personalizado que aceita todos os certificados
        val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
            override fun checkClientTrusted(chain: Array<out java.security.cert.X509Certificate>?, authType: String?) {}
            override fun checkServerTrusted(chain: Array<out java.security.cert.X509Certificate>?, authType: String?) {}
            override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> = arrayOf()
        })

        // Cria um SSLContext personalizado que usa o TrustManager personalizado
        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(null, trustAllCerts, java.security.SecureRandom())

        // Configura o OkHttpClient para aceitar todos os certificados
        return OkHttpClient.Builder()
            .sslSocketFactory(sslContext.socketFactory, trustAllCerts[0] as X509TrustManager)
            .hostnameVerifier { _, _ -> true }
            .build()
    }
}