package com.example.terminator

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import com.example.terminator.SqlListModel

class DatabaseHandler(context: Context) : SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {
    companion object{
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "UserDatabase"
        private val CUSTOMER_TABLE = "CustomerTable"
        private val KEY_NAME = "name"
        private val KEY_GENDER = "gender"
        private val KEY_HOUSENUMBER = "house number"
        private val KEY_PHONE = "phone number"
        private val KEY_EMAIL = "email"
        private val KEY_PEST = "pest to control"
        private val KEY_DATE = "date to visit"

    }

    //creating SQLite Database
    override fun onCreate(db: SQLiteDatabase?) {
        //defining our query
        val CREATE_SUBMITTED_TABLE = ("CREATE TABLE " + CUSTOMER_TABLE + "("
                + KEY_NAME + " TEXT, " + KEY_GENDER + "TEXT," + KEY_HOUSENUMBER +
                "TEXT," + KEY_PHONE + "INTEGER PRIMARY KEY," +
                KEY_EMAIL + " TEXT" + KEY_PEST + "TEXT, "
                + KEY_DATE + " TEXT,"
                +  ")")
        //execute our query
        db?.execSQL(CREATE_SUBMITTED_TABLE)
    }

    //notifying the db incase of a change
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS" + CUSTOMER_TABLE)
        onCreate(db)
    }

    //method to create records
    fun addUsers(sqlListModel: SqlListModel): Long{
        val db = this.writableDatabase
        //defining and placing our content
        val contentValues = ContentValues()
        //put data to respective fields
        contentValues.put(KEY_NAME, sqlListModel.userName)
        contentValues.put(KEY_GENDER, sqlListModel.userGender)
        contentValues.put(KEY_HOUSENUMBER, sqlListModel.userHouse)
        contentValues.put(KEY_PHONE, sqlListModel.userPhone)
        contentValues.put(KEY_EMAIL, sqlListModel.userEmail)
        contentValues.put(KEY_PEST, sqlListModel.userPest)
        contentValues.put(KEY_DATE, sqlListModel.userDate)





        //insert this row to table in database
        val success = db.insert(CUSTOMER_TABLE,null,contentValues)
        //close the database connection
        db.close()
        //return output of method
        return success

    }

    //method to read data
    fun readData(): List<SqlListModel>{
        //get resizeable array for our data
        val userArray: ArrayList<SqlListModel> = ArrayList<SqlListModel>()
        //defining our select query
        val selectQuery = "SELECT  * FROM $CUSTOMER_TABLE"
        //define the sqlite method
        val db = this.readableDatabase
        //reading our data and saving it to our arraylist
        var cursor: Cursor? = null
        try{
            cursor = db.rawQuery(selectQuery, null)
        }catch (e: SQLiteException) {
            db.execSQL(selectQuery)
            return ArrayList()
        }
        //iterating our records in db and storing them to our model
        var userName: String
        var userGender: String
        var userHouse: String
        var userPhone: Int
        var userEmail: String
        var userPest: String
        var userDate: String

        if (cursor.moveToFirst()) {
            do {
                userName = cursor.getString(cursor.getColumnIndex("name"))
                userGender = cursor.getString(cursor.getColumnIndex("gender"))
                userHouse = cursor.getString(cursor.getColumnIndex("house"))
                userPhone = cursor.getInt(cursor.getColumnIndex("phone number"))
                userEmail = cursor.getString(cursor.getColumnIndex("email"))
                userPest = cursor.getString(cursor.getColumnIndex("pest to control"))
                userDate = cursor.getString(cursor.getColumnIndex("Date"))

                val emp= SqlListModel(userName = userName, userGender = userGender, userHouse = userHouse, userPhone = userPhone, userEmail = userEmail, userPest = userPest, userDate = userDate)
                userArray.add(emp)
            } while (cursor.moveToNext())
        }

        return userArray
    }

    //update method
    fun updateData(sqlListModel: SqlListModel) : Int{
        //process in db
        val db  = this.writableDatabase
        //content values
        val contentValues = ContentValues()
        //put the details inside the respective colums
        contentValues.put(KEY_NAME, sqlListModel.userName)
        contentValues.put(KEY_GENDER, sqlListModel.userGender)
        contentValues.put(KEY_HOUSENUMBER, sqlListModel.userHouse)
        contentValues.put(KEY_PHONE, sqlListModel.userPhone)
        contentValues.put(KEY_EMAIL, sqlListModel.userEmail)
        contentValues.put(KEY_PEST, sqlListModel.userPest)
        contentValues.put(KEY_DATE, sqlListModel.userDate)


        //updating the row
        val success = db.update(CUSTOMER_TABLE,contentValues,"email=" + sqlListModel.userEmail,null)
        //close the connection
        db.close()

        return success

    }

    //delete method
    fun deleteData(sqlListModel: SqlListModel) : Int{
        //process
        val db = this.writableDatabase
        //contentvalues
        val contentValues = ContentValues()
        contentValues.put(KEY_EMAIL, sqlListModel.userEmail)
        //delete process
        val success = db.delete(CUSTOMER_TABLE,"email=" + sqlListModel.userEmail,null)
        db.close()
        return success

    }


}

