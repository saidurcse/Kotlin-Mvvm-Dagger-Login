package saidur.demo.kotlin.view.signup

import dagger.Component
import saidur.demo.kotlin.DemoComponent
import saidur.demo.kotlin.view.signup.view.SignupViewModel

@SignupScope
@Component(dependencies = [DemoComponent::class], modules = [SignupModule::class])
interface SignupComponent : SignupGraph {

    fun inject(signupActivity: SignupActivity)

    fun inject(signupViewModel: SignupViewModel)
}