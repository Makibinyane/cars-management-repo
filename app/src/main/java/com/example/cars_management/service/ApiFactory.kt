package com.example.cars_management.service

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ApiFactory {
    private const val DEFAULT_TIMEOUT = 15L
    private val okhttpClient = OkHttpClient().newBuilder()
        .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .build()


    private fun retrofit() : Retrofit = Retrofit.Builder()
        .client(okhttpClient)
        .baseUrl("https://demo6651614.mockable.io/")
        .addConverterFactory(MoshiConverterFactory.create().asLenient())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val carServiceApi : CarServiceApi = retrofit().create(CarServiceApi::class.java)
}