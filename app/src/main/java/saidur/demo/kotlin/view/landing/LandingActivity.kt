package saidur.demo.kotlin.view.landing

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import saidur.demo.kotlin.DemoApplication
import saidur.demo.kotlin.R
import saidur.demo.kotlin.databinding.ActivityLandingBinding
import saidur.demo.kotlin.view.landing.view.LandingViewModel

class LandingActivity : AppCompatActivity() {

    private var binding: ActivityLandingBinding? = null
    private var landingComponent: LandingComponent? = null

    private var landingViewModel: LandingViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        super.onCreate(savedInstanceState)

        landingViewModel = ViewModelProviders.of(this).get(LandingViewModel::class.java!!)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_landing)

        val application = DemoApplication.getInstance(this)
        landingComponent = DaggerLandingComponent.builder()
            .demoComponent(application.appComponent)
            .landingModule(LandingModule(this))
            .build()
        landingComponent!!.inject(this)

        binding!!.setLifecycleOwner(this)
        binding!!.setViewModel(landingViewModel)
    }
}
