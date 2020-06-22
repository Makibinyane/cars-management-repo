package com.example.cars_management.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.cars_management.R
import com.example.cars_management.model.Car
import kotlinx.android.synthetic.main.activity_car_details.*


class CarDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_details)

        val intent = intent
        if (intent.hasExtra(CAR_EXTRA)) {
            val car = intent.extras?.getParcelable<Car>(CAR_EXTRA)
            showCarDetails(car)
        }

        setUpScreenToolbar()

    }

    private fun setUpScreenToolbar() {
        val actionbar = supportActionBar
        //set actionbar title
        actionbar?.title = getString(R.string.car_details_title)
        //set back button
        actionbar?.setDisplayHomeAsUpEnabled(true)
        actionbar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun showCarDetails(car: Car?) {
        car?.let {
            val carModelAndType = getString(R.string.car_model_and_type, car.model, car.type)
            model_type_textview.text = carModelAndType
            mileage_textview.text = car.mileage
            car_description_textview.text = car.description
            Glide.with(this)
                .load(car.imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .into(media_image)
        }
    }
}
