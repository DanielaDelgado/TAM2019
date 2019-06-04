package com.example.myapplication

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHandler(context: Context, name: String, factory:SQLiteDatabase.CursorFactory, version: Int):
        SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABESE_VERSION){

    companion object {
        private val DATABASE_NAME ="MyData.db"
        private val DATABESE_VERSION = 1

        val CUSTOMERS_TABLE_NAME ="Customers"
        val COLUMN_CUSTOMERID="customerid"
        val COLUMN_CUSTOMERNAME="customername"
        val COLUMN_RFC="rfc"
        val COLUMN_CEL="cel"
        val COLUMN_MAIL="mail"
        val COLUMN_FECHA="fecha"

    }
    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_CUSTOMERS_TABLE:String =("CREATE TABLE $CUSTOMERS_TABLE_NAME ("+
                "$COLUMN_CUSTOMERID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COLUMN_CUSTOMERNAME TEXT," +
                "$COLUMN_RFC TEXT,"+
                "$COLUMN_CEL TEXT,"+
                "$COLUMN_MAIL TEXT,"+
                "$COLUMN_FECHA TEXT")
        db?.execSQL(CREATE_CUSTOMERS_TABLE)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
    fun getCustomers(mCtx:Context): ArrayList<Customer>
    {
        val qry="Select * From $CUSTOMERS_TABLE_NAME"
        val db=this.readableDatabase
        val cursor=db.rawQuery(qry,null)
        val customer=
    }

}

