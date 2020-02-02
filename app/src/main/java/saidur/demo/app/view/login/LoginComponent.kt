package saidur.demo.app.view.login

import dagger.Component
import saidur.demo.app.DemoComponent
import saidur.demo.app.view.login.view.LoginViewModel

@LoginScope
@Component(dependencies = [DemoComponent::class], modules = [LoginModule::class])
interface LoginComponent : LoginGraph {

    fun inject(loginActivity: LoginActivity)

    fun inject(loginViewModel: LoginViewModel)
}