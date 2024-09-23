package com.ismailmesutmujde.kotlinstoragesqlitereadydatabaseusage.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import com.ismailmesutmujde.kotlinstoragesqlitereadydatabaseusage.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        copyDatabase()

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