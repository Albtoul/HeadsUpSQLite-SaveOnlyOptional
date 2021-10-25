package com.example.headsupsqlite_saveonlyoptional

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHlpr(context: Context?) : SQLiteOpenHelper(context, "celebrity.db", null, 1) {
  var   sqliteDatabase: SQLiteDatabase=writableDatabase
    override fun onCreate(db: SQLiteDatabase?) {
        if(db!=null){
            db.execSQL("create table celebritytable(Name text,tobo1 text,tobo2 text,tobo3 text)")
        }

    }

    override fun onUpgrade(db: SQLiteDatabase?, old: Int, new: Int) {

    }
    fun save(s:String,s1:String,s2:String,s3:String): Long {

        val cv =ContentValues()
        cv.put("Name",s)
        cv.put("tobo1",s1)
        cv.put("tobo2",s2)
        cv.put("tobo3",s3)

       var stat= sqliteDatabase.insert("celebritytable",null,cv)
return stat
    }

    @SuppressLint("Range")
    fun retrive():ArrayList<List<String>>{
        val list= arrayListOf<List<String>>()
        val c:Cursor=sqliteDatabase.query("celebritytable",null,null,null,null,null,null)

        if(c.moveToFirst()){
            do{
               list.add(listOf(c.getString(c.getColumnIndex("Name"))
                   ,c.getString(c.getColumnIndex("tobo1"))
                   ,c.getString(c.getColumnIndex("tobo2"))
                   , c.getString(c.getColumnIndex("tobo3"))))
            }while (c.moveToNext())
        }
        return list
    }


}