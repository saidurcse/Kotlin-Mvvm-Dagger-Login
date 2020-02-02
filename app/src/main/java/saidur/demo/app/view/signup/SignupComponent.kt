package saidur.demo.app.view.signup

import dagger.Component
import saidur.demo.app.DemoComponent
import saidur.demo.app.view.login.LoginGraph
import saidur.demo.app.view.signup.view.SignupViewModel

@SignupScope
@Component(dependencies = [DemoComponent::class], modules = [SignupModule::class])
interface SignupComponent : SignupGraph {

    fun inject(signupActivity: SignupActivity)

    fun inject(signupViewModel: SignupViewModel)
}