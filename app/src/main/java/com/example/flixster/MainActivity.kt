package com.example.flixster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.ViewCompat

/**
 * The MainActivity for the Flixster++ app.
 * Launches a [UpcomingMoviesFragment] and [PopularMoviesFragment].
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val supportFragmentManager = supportFragmentManager
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.content, UpcomingMoviesFragment(this), null).commit()
        // try to use the same fragment transaction
        val fragmentTransaction2 = supportFragmentManager.beginTransaction()
        fragmentTransaction2.replace(R.id.content2, PopularMoviesFragment(this), null).commit()
    }
}