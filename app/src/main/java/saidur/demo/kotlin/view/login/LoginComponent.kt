package saidur.demo.kotlin.view.login

import dagger.Component
import saidur.demo.kotlin.DemoComponent
import saidur.demo.kotlin.view.login.view.LoginViewModel

@LoginScope
@Component(dependencies = [DemoComponent::class], modules = [LoginModule::class])
interface LoginComponent : LoginGraph {

    fun inject(loginActivity: LoginActivity)

    fun inject(loginViewModel: LoginViewModel)
}