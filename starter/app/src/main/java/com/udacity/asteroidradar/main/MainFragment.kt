package com.udacity.asteroidradar.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.udacity.asteroidradar.R
import com.udacity.asteroidradar.dataBase.AsteroidDb
import com.udacity.asteroidradar.databinding.FragmentMainBinding

class MainFragment() : Fragment() {


    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentMainBinding.inflate(inflater)
        val adapter = AsteroidItemsAdapter()

        //binding.viewModel = viewModel

        val application = requireNotNull(this.activity).application

        val dataSource = AsteroidDb.getInstance(application).asteroidDao
        val imageSource = AsteroidDb.getInstance(application).imageDao

        val viewModelFactory = AsteroidViewModelFactory(dataSource,
                                                        imageSource,
                                                        application)

        val sleepTrackerViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(MainViewModel::class.java)


        binding.asteroidRecycler.adapter = adapter

        viewModel.dome.observe(viewLifecycleOwner, { items ->
            adapter.submitList(items)
        })
        binding.lifecycleOwner = this
        binding.viewModel = sleepTrackerViewModel


        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return true
    }
}