package com.example.playstore

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ImageButton>(R.id.profileButton).setOnClickListener {
            Toast.makeText(this, "Profile and settings will be show here!", Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageButton>(R.id.notifications).setOnClickListener {
            Toast.makeText(this, "Notifications will be show here!", Toast.LENGTH_SHORT).show()
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, GameFragment())
            .commit()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationBar)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_games -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, GameFragment())
                        .commit()
                    true
                }
                R.id.nav_apps -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, AppsFragment())
                        .commit()
                    true
                }
                R.id.nav_search -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, SearchFragment())
                        .commit()
                    true
                }
                R.id.nav_offers -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, OffersFragment())
                        .commit()
                    true
                }
                R.id.nav_books -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, BooksFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }

    }
}
