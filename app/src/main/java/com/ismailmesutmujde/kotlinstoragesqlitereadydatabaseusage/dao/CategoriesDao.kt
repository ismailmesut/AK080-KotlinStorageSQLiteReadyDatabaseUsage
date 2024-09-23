package com.ismailmesutmujde.kotlinstoragesqlitereadydatabaseusage.dao

import com.ismailmesutmujde.kotlinstoragesqlitereadydatabaseusage.model.Categories
import com.ismailmesutmujde.kotlinstoragesqlitereadydatabaseusage.sqlite.DatabaseHelper

class CategoriesDao {

    fun allCategories(dbh:DatabaseHelper) : ArrayList<Categories> {
        val categoryList = ArrayList<Categories>()
        val db = dbh.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM categories", null)

        while (cursor.moveToNext()) {
            val category = Categories(cursor.getInt(cursor.getColumnIndexOrThrow("category_id")),
                cursor.getString(cursor.getColumnIndexOrThrow("category_name")))

            categoryList.add(category)
        }
        return categoryList
    }
}