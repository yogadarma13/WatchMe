package com.yogadarma.watchme.presentation

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yogadarma.watchme.R
import com.yogadarma.watchme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var navView: BottomNavigationView
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbar)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        navView = binding.navView

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.movieFragment || destination.id == R.id.tvShowFragment || destination.id == R.id.favoriteFragment) {
                binding.toolbar.visibility = View.VISIBLE
                navView.visibility = View.VISIBLE
            } else if (destination.id == R.id.settingFragment) {
                binding.toolbar.visibility = View.VISIBLE
                navView.visibility = View.GONE
            } else {
                binding.toolbar.visibility = View.GONE
                navView.visibility = View.GONE
            }
        }

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.movieFragment, R.id.tvShowFragment, R.id.favoriteFragment
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

}