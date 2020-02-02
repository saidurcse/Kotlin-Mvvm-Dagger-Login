package saidur.demo.app.view.login

import android.os.Bundle
import android.text.TextUtils
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import java.util.Objects

import saidur.demo.app.DemoApplication
import saidur.demo.app.database.DatabaseSingleton
import saidur.demo.app.databinding.ActivityLoginBinding
import saidur.demo.app.view.login.view.LoginViewModel
import android.content.Intent
import saidur.demo.app.view.landing.LandingActivity


class LoginActivity : AppCompatActivity() {

    private var binding: ActivityLoginBinding? = null
    private var loginComponent: LoginComponent? = null

    private var loginViewModel: LoginViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        super.onCreate(savedInstanceState)

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        binding = DataBindingUtil.setContentView(this, saidur.demo.app.R.layout.activity_login)

        val application = DemoApplication.getInstance(this)
        loginComponent = DaggerLoginComponent.builder()
            .demoComponent(application.appComponent)
            .loginModule(LoginModule(this))
            .build()
        loginComponent!!.inject(this)

        binding!!.lifecycleOwner = this
        binding!!.viewModel = loginViewModel

        loginViewModel!!.user.observe(this, Observer { loginRequest ->
            if (TextUtils.isEmpty(Objects.requireNonNull(loginRequest).email)) {
                binding!!.EmailSignUp.error = "Enter an E-Mail Address"
                binding!!.EmailSignUp.requestFocus()
            } else if (!loginRequest!!.isEmailValid) {
                binding!!.EmailSignUp.error = "Enter a Valid E-mail Address"
                binding!!.EmailSignUp.requestFocus()
            } else if (TextUtils.isEmpty(Objects.requireNonNull(loginRequest).password)) {
                binding!!.PasswordSignUp.error = "Enter a Password"
                binding!!.PasswordSignUp.requestFocus()
            } else if (!loginRequest.isPasswordLengthGreaterThan5) {
                binding!!.PasswordSignUp.error = "Enter at least 6 Digit password"
                binding!!.PasswordSignUp.requestFocus()
            } else {
                val loginRequest1 = DatabaseSingleton.GetDatabase(applicationContext).signupDAO()
                    .GetUser(loginRequest.email!!, loginRequest.password!!)
                if (loginRequest1.email == loginRequest.email && loginRequest1.password == loginRequest.password) {
                    Toast.makeText(applicationContext, "Success", Toast.LENGTH_LONG)
                    binding!!.SignUpConfirm.text = "Success"
                    val openLandingPage = Intent(this@LoginActivity, LandingActivity::class.java)
                    startActivity(openLandingPage)
                } else {
                    Toast.makeText(applicationContext, "Please check again", Toast.LENGTH_LONG)
                }
            }
        })
    }
}
