package com.example.flixster

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.bumptech.glide.Glide

class MovieActivity : AppCompatActivity() {
    private lateinit var movieImageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var overviewTextView: TextView
    private lateinit var popularityTextView: TextView
    private lateinit var releaseDateTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        supportPostponeEnterTransition()
        // add back button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Find the views for the screen
        movieImageView = findViewById(R.id.movie_image)
        titleTextView = findViewById(R.id.title)
        overviewTextView = findViewById(R.id.overview)
        popularityTextView = findViewById(R.id.popularity)
        releaseDateTextView = findViewById(R.id.releaseDate)

        // Get the extra from the Intent
        val movie = intent.getSerializableExtra("MOVIE_EXTRA") as Movie

        // Set the title, description
        titleTextView.text = movie.title
        overviewTextView.text = movie.overview
        popularityTextView.text = popularityTextView.text.toString() + ":" + "\n" + movie.popularity
        releaseDateTextView.text = ("Release Date: \n" + movie.releaseDate)

        // Load the media image
        ViewCompat.setTransitionName(movieImageView, movie.title)
        //postponeEnterTransition()

        Glide.with(this)
            .load(("https://image.tmdb.org/t/p/w500/"+movie.posterPath))
            .centerInside()
            .into(movieImageView)
        startPostponedEnterTransition()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            supportFinishAfterTransition()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}