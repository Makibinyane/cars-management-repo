package com.example.cars_management.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cars_management.R
import com.example.cars_management.model.Car

class CarAdapter(private val clickListener: (Car) -> Unit): ListAdapter<Car, CarAdapter.CarItemViewHolder>(CarDiffCallback()) {

    class CarDiffCallback : DiffUtil.ItemCallback<Car>() {
        override fun areItemsTheSame(oldItem: Car, newItem: Car): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: Car, newItem: Car): Boolean {
            return oldItem.description == newItem.description
                    && oldItem.model == newItem.model
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.car_list_item, parent, false)
        return CarItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarItemViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }

    class CarItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var carDescriptionTextView: TextView = itemView.findViewById(R.id.car_description_textview)
        private var carModelTextView: TextView = itemView.findViewById(R.id.car_model_textview)
        private var carImageView: ImageView = itemView.findViewById(R.id.avatar_image)

        fun bind(car: Car, clickListener: (Car) -> Unit) {
            carModelTextView.text = car.model
            carDescriptionTextView.text = car.description
            Glide.with(itemView)
                .load(car.imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .into(carImageView)

            itemView.setOnClickListener {
                clickListener(car)
            }
        }
    }


}