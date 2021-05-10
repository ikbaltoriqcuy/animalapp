package com.example.testalodokter.animalapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.testalodokter.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()  {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()
        setupNavigationDestistination()
        setupEventUI()
    }

    private fun setup() {
        navController = Navigation.findNavController(this, R.id.navHost)
    }

    private fun setupEventUI() {
        bottomNav.setOnNavigationItemSelectedListener (
            onNavigationItemSelectedListener
        )
    }

    private fun setupNavigationDestistination() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.loginFragment -> bottomNav.visibility = View.GONE
                R.id.accountFragment -> bottomNav.visibility = View.VISIBLE
                R.id.homeFragment -> bottomNav.visibility = View.VISIBLE
                R.id.animalFragment -> bottomNav.visibility = View.GONE
            }
        }
    }


    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.menuHome -> {
                navController.navigate(R.id.homeFragment)
                return@OnNavigationItemSelectedListener true

            }
            R.id.menuAccount -> {
                navController.navigate(R.id.accountFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

}