package saidur.demo.app.view.signup

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import java.util.Objects

import saidur.demo.app.DemoApplication
import saidur.demo.app.R
import saidur.demo.app.database.DatabaseSingleton
import saidur.demo.app.databinding.ActivitySignupBinding
import saidur.demo.app.view.login.LoginActivity
import saidur.demo.app.view.signup.model.SignupRequest
import saidur.demo.app.view.signup.view.SignupViewModel

class SignupActivity : AppCompatActivity() {

    private var binding: ActivitySignupBinding? = null
    private var signupComponent: SignupComponent? = null

    private var signupViewModel: SignupViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        super.onCreate(savedInstanceState)

        signupViewModel = ViewModelProviders.of(this).get(SignupViewModel::class.java)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)

        val application = DemoApplication.getInstance(this)
        signupComponent = DaggerSignupComponent.builder()
            .demoComponent(application.appComponent)
            .signupModule(SignupModule(this))
            .build()
        signupComponent!!.inject(this)

        binding!!.lifecycleOwner = this
        binding!!.viewModel = signupViewModel

        signupViewModel!!.user.observe(this, Observer { signupRequest ->
            if (TextUtils.isEmpty(Objects.requireNonNull(signupRequest).email)) {
                binding!!.EmailSignUp.error = "Enter an E-Mail Address"
                binding!!.EmailSignUp.requestFocus()
            } else if (!signupRequest!!.isEmailValid) {
                binding!!.EmailSignUp.error = "Enter a Valid E-mail Address"
                binding!!.EmailSignUp.requestFocus()
            } else if (TextUtils.isEmpty(Objects.requireNonNull(signupRequest).password)) {
                binding!!.PasswordSignUp.error = "Enter a Password"
                binding!!.PasswordSignUp.requestFocus()
            } else if (!signupRequest.isPasswordLengthGreaterThan5) {
                binding!!.PasswordSignUp.error = "Enter at least 6 Digit password"
                binding!!.PasswordSignUp.requestFocus()
            } else {
                //binding.EmailSignUp.setText(signupRequest.getEmail());
                //binding.PasswordSignUp.setText(signupRequest.getPassword());
                val signupUser = SignupRequest(signupRequest.email!!, signupRequest.password!!)
                DatabaseSingleton.GetDatabase(applicationContext).signupDAO().AddUser(signupUser)

                val login = Intent(applicationContext, LoginActivity::class.java)
                startActivity(login)
            }
        })

    }
}
