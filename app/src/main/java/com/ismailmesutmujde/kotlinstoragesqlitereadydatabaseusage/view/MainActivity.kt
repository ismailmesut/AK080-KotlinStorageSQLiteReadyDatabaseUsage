package com.ismailmesutmujde.kotlinstoragesqlitereadydatabaseusage.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import com.ismailmesutmujde.kotlinstoragesqlitereadydatabaseusage.R
import com.ismailmesutmujde.kotlinstoragesqlitereadydatabaseusage.dao.CategoriesDao
import com.ismailmesutmujde.kotlinstoragesqlitereadydatabaseusage.dao.MoviesDao
import com.ismailmesutmujde.kotlinstoragesqlitereadydatabaseusage.sqlite.DatabaseHelper


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        copyDatabase()

        val db = DatabaseHelper(this)

        val categoryList = CategoriesDao().allCategories(db)

        for(c in categoryList) {
            Log.e("Category id", (c.category_id).toString())
            Log.e("Category name", c.category_name)
        }

        val movieList = MoviesDao().allMoviesByCategoryId(db, 2)

        for (m in movieList) {

            Log.e("Movie id", (m.movie_id).toString())
            Log.e("Movie name", m.movie_name)
            Log.e("Movie year", (m.movie_year).toString())
            Log.e("Movie poster", m.movie_poster)
            Log.e("Movie category id", (m.category.category_id).toString())
            Log.e("Movie category name", m.category.category_name)
            Log.e("Movie director id", (m.director.director_id).toString())
            Log.e("Movie director name", m.director.director_name)
        }


    }

    fun copyDatabase() {
        val db = DatabaseCopyHelper(this)

        try {
            db.createDataBase()
        } catch (e:Exception) {
            e.printStackTrace()
        }

        try {
            db.openDataBase()
        } catch (e:Exception) {
            e.printStackTrace()
        }
    }
}