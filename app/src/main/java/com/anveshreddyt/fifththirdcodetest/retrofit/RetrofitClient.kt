package com.anveshreddyt.fifththirdcodetest.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.Interceptor
import okhttp3.Response

object RetrofitClient {

    private const val MainServer = "https://api.weatherstack.com/"

    private val retrofitClient: Retrofit.Builder by lazy {

        val okhttpClient = OkHttpClient.Builder()
        Retrofit.Builder()
            .baseUrl(MainServer)
            .client(okhttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiInterface: ApiInterface by lazy {
        retrofitClient
            .build()
            .create(ApiInterface::class.java)
    }
}