package saidur.demo.app.view.signup.model

import android.util.Patterns
import androidx.room.Entity
import androidx.room.PrimaryKey

import com.google.gson.annotations.SerializedName

@Entity(tableName = "Signup")
class SignupRequest {

    @PrimaryKey
    @SerializedName("email")
    lateinit var email: String

    @SerializedName("password")
    var password: String? = null

    val isEmailValid: Boolean
        get() = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    val isPasswordLengthGreaterThan5: Boolean
        get() = password!!.length > 5

    constructor() {}

    constructor(email: String, password: String) {
        this.email = email
        this.password = password
    }
}
