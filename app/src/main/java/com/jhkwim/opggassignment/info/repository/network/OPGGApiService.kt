package com.jhkwim.opggassignment.info.repository.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object OPGGApiService {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val client = OkHttpClient().newBuilder()
        .addInterceptor(loggingInterceptor)
        .build()

    private fun getRetrofit() = Retrofit.Builder()
        .client(client)
        .baseUrl("https://codingtest.op.gg")
        .addConverterFactory(GsonConverterFactory.create())
        .addConverterFactory(EnumConverterFactory())
        .build()

    val opggService = getRetrofit().create(OPGGService::class.java)
}