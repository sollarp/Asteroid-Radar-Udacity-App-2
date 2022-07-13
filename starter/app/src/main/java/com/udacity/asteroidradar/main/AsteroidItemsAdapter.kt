package com.udacity.asteroidradar.main

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.databinding.FragmentListBinding

private val TAG = "SecondActivity"

class AsteroidItemsAdapter():
    ListAdapter<Asteroid, AsteroidItemsAdapter.AsteroidViewHolder>(AsteroidDiffCallback()) {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsteroidViewHolder {
        Log.d(TAG, "Failure: action happened in Adapter")
        val itemBinding = FragmentListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)

        return AsteroidViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: AsteroidViewHolder, position: Int) {
        holder.onBind(getItem(position))
        Log.d(TAG, "Failure: action happened in Adapter")

    }

   /* override fun getItemCount(): Int {
        return Asteroid.size
    }*/

    class AsteroidViewHolder (val binding: FragmentListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var _asteroid: Asteroid


        fun onBind(asteroid: Asteroid) {
            _asteroid = asteroid
            binding.asteroid = _asteroid
            binding.executePendingBindings()

        }

        companion object {
            fun from(parent: ViewGroup): AsteroidViewHolder {
                val binding = FragmentListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return AsteroidViewHolder(binding)
            }
        }
    }

    class AsteroidDiffCallback : DiffUtil.ItemCallback<Asteroid>() {
        override fun areItemsTheSame(oldItem: Asteroid, newItem: Asteroid): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Asteroid, newItem: Asteroid): Boolean {
            return oldItem == newItem
        }

    }

    class AsteroidListener(private val clickListener: (asteroid: Asteroid) -> Unit) {
        fun onClick(asteroid: Asteroid) = clickListener(asteroid)
    }
}