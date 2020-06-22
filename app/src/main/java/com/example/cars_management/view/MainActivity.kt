package com.example.cars_management.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cars_management.R
import com.example.cars_management.model.Car
import com.example.cars_management.viewmodel.CarViewModel
import kotlinx.android.synthetic.main.activity_main.*

val CAR_EXTRA = "Car"
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpAdapter()
        setUpScreenToolbar()
    }

    private fun setUpScreenToolbar() {
        val actionbar = supportActionBar
        //set actionbar title
        actionbar?.title = getString(R.string.car_list_title)
    }

    private fun setUpAdapter() {
        val viewModel = ViewModelProvider(this).get(CarViewModel::class.java)
        viewModel.fetchCars()
        viewModel.carsLiveData.observe(this, Observer { cars ->
            val adapter = CarAdapter {
                    car: Car -> handleVideoClick(car)}
            cars_recyclerview.adapter = adapter
            adapter.submitList(cars)
        })
    }

    private fun handleVideoClick(car: Car) {
        val activityIntent = Intent(this, CarDetailsActivity::class.java)
        activityIntent.putExtra(CAR_EXTRA, car)
        startActivity(activityIntent)
    }
}
