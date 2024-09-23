package com.ismailmesutmujde.kotlinstoragesqlitereadydatabaseusage.dao

import com.ismailmesutmujde.kotlinstoragesqlitereadydatabaseusage.model.Categories
import com.ismailmesutmujde.kotlinstoragesqlitereadydatabaseusage.model.Directors
import com.ismailmesutmujde.kotlinstoragesqlitereadydatabaseusage.model.Movies
import com.ismailmesutmujde.kotlinstoragesqlitereadydatabaseusage.sqlite.DatabaseHelper

class MoviesDao {

    fun allMoviesByCategoryId(dbh : DatabaseHelper, category_id : Int) : ArrayList<Movies> {
        val moviesList = ArrayList<Movies>()
        val db = dbh.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM movies,categories,directors WHERE movies.category_id = categories.category_id AND movies.director_id = directors.director_id AND movies.category_id = $category_id", null)

        while (cursor.moveToNext()) {
            val category = Categories(cursor.getInt(cursor.getColumnIndexOrThrow("category_id")),
                cursor.getString(cursor.getColumnIndexOrThrow("category_name")))

            val director = Directors(cursor.getInt(cursor.getColumnIndexOrThrow("director_id")),
                cursor.getString(cursor.getColumnIndexOrThrow("director_name")))

            val movie = Movies(cursor.getInt(cursor.getColumnIndexOrThrow("movie_id")),
                cursor.getString(cursor.getColumnIndexOrThrow("movie_name")),
                cursor.getInt(cursor.getColumnIndexOrThrow("movie_year")),
                cursor.getString(cursor.getColumnIndexOrThrow("movie_poster")),
                category, director)
            moviesList.add(movie)
        }

        return moviesList
    }
}