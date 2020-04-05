package saidur.demo.kotlin.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.activity_signup.*
import saidur.demo.kotlin.R
import saidur.demo.kotlin.databinding.ActivitySplashBinding
import saidur.demo.kotlin.model.ObjectManager
import saidur.demo.kotlin.util.SharedPrefsHelper
import saidur.demo.kotlin.view.login.LoginActivity
import saidur.demo.kotlin.view.signup.SignupActivity
import saidur.demo.kotlin.view.splash.SplashActivity
import javax.inject.Inject


class DemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        super.onCreate(savedInstanceState)

        val intent = Intent(applicationContext, SplashActivity::class.java)
        startActivity(intent)
        finish()
    }
}
