package com.ismailmesutmujde.kotlinstoragesqlitereadydatabaseusage.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import com.ismailmesutmujde.kotlinstoragesqlitereadydatabaseusage.R
import com.ismailmesutmujde.kotlinstoragesqlitereadydatabaseusage.dao.CategoriesDao
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