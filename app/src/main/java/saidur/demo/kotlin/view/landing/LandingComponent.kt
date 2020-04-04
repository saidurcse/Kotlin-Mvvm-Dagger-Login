package saidur.demo.kotlin.view.landing

import dagger.Component
import saidur.demo.kotlin.DemoComponent

@LandingScope
@Component(dependencies = [DemoComponent::class], modules = [LandingModule::class])
interface LandingComponent : LandingGraph {

    fun inject(landingActivity: LandingActivity)

    //fun inject(landingViewModel: LandingViewModel)
}