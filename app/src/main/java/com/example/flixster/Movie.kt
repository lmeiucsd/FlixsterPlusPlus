package com.example.flixster
import android.support.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

/**
 * The Model for storing a single movie from the MoviesDB API
 *
 * SerializedName tags MUST match the JSON response for the
 * object to correctly parse with the gson library.
 */
@Keep
@Serializable
data class Movie (
    @SerializedName("title")
    var title: String? = null,

    @SerializedName("overview")
    var overview: String? = null,

    @SerializedName("poster_path")
    var posterPath : String? = null,

    @SerializedName("release_date")
    var releaseDate : String? = null,

    @SerializedName("popularity")
    var popularity : String? = null
) : java.io.Serializable