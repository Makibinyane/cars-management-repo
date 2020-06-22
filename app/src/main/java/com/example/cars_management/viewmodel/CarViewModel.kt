package com.example.cars_management.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars_management.model.Car
import com.example.cars_management.repo.CarRepository
import com.example.cars_management.service.ApiFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CarViewModel (private val repository: CarRepository = CarRepository(ApiFactory.carServiceApi)): ViewModel() {

    val carsLiveData = MutableLiveData<List<Car>>()

    fun fetchCars() {
        viewModelScope.launch(Dispatchers.IO) {
            val videos = repository.getCars()
            carsLiveData.postValue(videos)
        }
    }
}