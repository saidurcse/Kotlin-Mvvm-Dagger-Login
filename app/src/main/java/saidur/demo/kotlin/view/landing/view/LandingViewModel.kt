package saidur.demo.kotlin.view.landing.view

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import saidur.demo.kotlin.util.SharedPrefsHelper
import saidur.demo.kotlin.view.weather.WeatherActivity
import javax.inject.Inject

class LandingViewModel : ViewModel() {
    @Inject
    lateinit var sharedPrefsHelper: SharedPrefsHelper
    @Inject
    lateinit var context: Context

    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    fun onClickWeather(view: View) {
        val context = view.context
        val openLoginPage = Intent(context, WeatherActivity::class.java)
        context.startActivity(openLoginPage)
    }
}
