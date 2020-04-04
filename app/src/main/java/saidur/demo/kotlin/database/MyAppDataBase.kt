package saidur.demo.kotlin.database

import androidx.room.Database
import androidx.room.RoomDatabase

import saidur.demo.kotlin.database.dao.SignupDAO
import saidur.demo.kotlin.view.signup.model.SignupRequest

@Database(entities = [SignupRequest::class], version = 1, exportSchema = false)
abstract class MyAppDataBase : RoomDatabase() {
    abstract fun signupDAO(): SignupDAO
}

