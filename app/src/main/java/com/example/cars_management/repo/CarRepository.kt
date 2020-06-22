package com.example.cars_management.repo

import com.example.cars_management.model.Car
import com.example.cars_management.service.CarServiceApi

class CarRepository (private var service: CarServiceApi) : BaseRepository() {

    suspend fun getCars() : MutableList<Car>?{
        val carResponse = safeApiCall(
            call = {service.getCarsAsync().await()},
            errorMessage = "Error Fetching Cars"
        )
        return carResponse?.cars?.toMutableList()
    }
}