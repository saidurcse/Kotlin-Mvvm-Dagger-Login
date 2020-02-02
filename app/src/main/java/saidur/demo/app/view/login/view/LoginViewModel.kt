package saidur.demo.app.view.login.view

import android.content.Context
import android.view.View

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import javax.inject.Inject

import saidur.demo.app.util.SharedPrefsHelper
import saidur.demo.app.view.login.model.LoginRequest

class LoginViewModel : ViewModel() {
    @Inject
    lateinit var sharedPrefsHelper: SharedPrefsHelper
    @Inject
    lateinit var context: Context

    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    private var userMutableLiveData: MutableLiveData<LoginRequest>? = null


    val user: MutableLiveData<LoginRequest>
        get() {

            if (userMutableLiveData == null) {
                userMutableLiveData = MutableLiveData()
            }
            return userMutableLiveData!!
        }

    fun onClick(view: View) {
        val loginRequest = LoginRequest(email.value!!, password.value!!)

        userMutableLiveData!!.value = loginRequest
    }
}
