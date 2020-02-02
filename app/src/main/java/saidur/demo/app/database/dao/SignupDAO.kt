package saidur.demo.app.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import saidur.demo.app.view.login.model.LoginRequest
import saidur.demo.app.view.signup.model.SignupRequest

@Dao
interface SignupDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun AddUser(leads: SignupRequest)

    @Query("Select * from Signup where email = :email and password = :password")
    fun GetUser(email: String, password: String): LoginRequest
}
