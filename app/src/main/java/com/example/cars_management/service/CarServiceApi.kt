package com.example.cars_management.service

import com.example.cars_management.model.CarResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface CarServiceApi {
    @GET("cars")
    fun getCarsAsync(): Deferred<Response<CarResponse>>
}
