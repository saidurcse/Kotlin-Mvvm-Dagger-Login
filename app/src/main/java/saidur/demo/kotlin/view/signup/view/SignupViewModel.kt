package saidur.demo.kotlin.view.signup.view

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import saidur.demo.kotlin.util.SharedPrefsHelper
import saidur.demo.kotlin.view.login.LoginActivity
import saidur.demo.kotlin.view.signup.model.SignupRequest
import javax.inject.Inject

class SignupViewModel : ViewModel() {
    private val signUpRequest = SignupRequest()

    @Inject
    lateinit var sharedPrefsHelper: SharedPrefsHelper
    @Inject
    lateinit var context: Context

    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    private var userMutableLiveData: MutableLiveData<SignupRequest>? = null

    val user: MutableLiveData<SignupRequest>
        get() {

            if (userMutableLiveData == null) {
                userMutableLiveData = MutableLiveData()
            }
            return userMutableLiveData!!
        }

    fun onClick(view: View) {
        if(signUpRequest.isDataValid()){
            //Toast.makeText(context, "Email or Password is blank", Toast.LENGTH_LONG).show()
        } else {
            val signupUser = SignupRequest(email.value!!, password.value!!)

            userMutableLiveData!!.value = signupUser
        }
    }

    fun onClickLogin(view: View) {
        val context = view.context
        val openLoginPage = Intent(context, LoginActivity::class.java)
        context.startActivity(openLoginPage)
    }
}
