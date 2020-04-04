package saidur.demo.kotlin.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import saidur.demo.kotlin.view.login.model.LoginRequest
import saidur.demo.kotlin.view.signup.model.SignupRequest

@Dao
interface SignupDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun AddUser(leads: SignupRequest)

    @Query("Select * from Signup where email = :email and password = :password")
    fun GetUser(email: String, password: String): LoginRequest
}
