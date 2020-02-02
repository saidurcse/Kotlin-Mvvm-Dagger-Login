package saidur.demo.app.view.splash

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.Window
import android.view.WindowManager

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

import javax.inject.Inject

import saidur.demo.app.R
import saidur.demo.app.databinding.ActivitySplashBinding
import saidur.demo.app.model.ObjectManager
import saidur.demo.app.view.login.LoginActivity
import saidur.demo.app.view.signup.SignupActivity


class SplashActivity : AppCompatActivity() {

    private var binding: ActivitySplashBinding? = null

    @Inject
    lateinit var objectManager: ObjectManager

    override fun onCreate(savedInstanceState: Bundle?) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        val SPLASH_TIME_OUT = 2000
        Handler().postDelayed({
            //Do some stuff here, like implement deep linking
            val intent = Intent(applicationContext, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME_OUT.toLong())
    }

    // Configuration in Android API 21 to set window to full screen.
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            if (hasFocus) {
                window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
            }
        }
    }
}
