package saidur.demo.app.view.landing

import dagger.Component
import saidur.demo.app.DemoComponent

@LandingScope
@Component(dependencies = [DemoComponent::class], modules = [LandingModule::class])
interface LandingComponent : LandingGraph {

    fun inject(landingActivity: LandingActivity)

    //fun inject(landingViewModel: LandingViewModel)
}