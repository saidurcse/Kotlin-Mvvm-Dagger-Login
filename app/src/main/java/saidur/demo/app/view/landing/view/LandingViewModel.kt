package saidur.demo.app.view.landing.view

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import saidur.demo.app.util.SharedPrefsHelper
import javax.inject.Inject

class LandingViewModel : ViewModel() {
    @Inject
    lateinit var sharedPrefsHelper: SharedPrefsHelper
    @Inject
    lateinit var context: Context

    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()
}
