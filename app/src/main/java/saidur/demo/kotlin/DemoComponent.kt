package saidur.demo.kotlin

import dagger.Component
import saidur.demo.kotlin.view.DemoActivity
import saidur.demo.kotlin.view.splash.SplashActivity

@DemoScope
@Component(modules = [DemoModule::class, ApiModule::class])
interface DemoComponent : DemoGraph {

    fun inject(activity: DemoActivity)
}
