package saidur.demo.kotlin.view.login.model

import android.util.Patterns

class LoginRequest {

    var email: String? = null

    var password: String? = null

    val isEmailValid: Boolean
        get() = Patterns.EMAIL_ADDRESS.matcher(email!!).matches()

    val isPasswordLengthGreaterThan5: Boolean
        get() = password!!.length > 5

    constructor() {}

    constructor(email: String, password: String) {
        this.email = email
        this.password = password
    }
}
