package saidur.demo.kotlin.view.landing.view

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import saidur.demo.kotlin.util.SharedPrefsHelper
import javax.inject.Inject

class LandingViewModel : ViewModel() {
    @Inject
    lateinit var sharedPrefsHelper: SharedPrefsHelper
    @Inject
    lateinit var context: Context

    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()
}
