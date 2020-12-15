package com.yogadarma.watchme.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yogadarma.watchme.R
import com.yogadarma.watchme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbar)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val navView: BottomNavigationView = binding.navView

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.movieFragment || destination.id == R.id.tvShowFragment || destination.id == R.id.favoriteFragment) {
                binding.toolbar.visibility = View.VISIBLE
                navView.visibility = View.VISIBLE
            } else {
                binding.toolbar.visibility = View.GONE
                navView.visibility = View.GONE
            }
        }

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.movieFragment, R.id.tvShowFragment, R.id.favoriteFragment
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

}