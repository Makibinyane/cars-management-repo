package com.example.cars_management.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Car(var id: Int,
               val model: String,
               val mileage: String,
               val type: String,
               val imageUrl: String,
               val description: String) : Parcelable