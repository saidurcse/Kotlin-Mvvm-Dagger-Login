package saidur.demo.app.view.signup.view

import android.content.Context
import android.view.View

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import javax.inject.Inject

import saidur.demo.app.util.SharedPrefsHelper
import saidur.demo.app.view.signup.model.SignupRequest

class SignupViewModel : ViewModel() {
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
        val signupUser = SignupRequest(email.value!!, password.value!!)

        userMutableLiveData!!.value = signupUser
    }
}
