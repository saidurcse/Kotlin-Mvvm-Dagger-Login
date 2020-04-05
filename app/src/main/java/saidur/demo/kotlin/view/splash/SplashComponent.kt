package saidur.demo.kotlin.view.splash

import dagger.Component
import saidur.demo.kotlin.DemoComponent

@SplashScope
@Component(dependencies = [DemoComponent::class], modules = [SplashModule::class])
interface SplashComponent : SplashGraph {
    fun inject(splashActivity: SplashActivity)
}