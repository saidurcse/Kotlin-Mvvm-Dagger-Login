package saidur.demo.app.view.signup

import android.content.Context

import dagger.Module
import dagger.Provides
import saidur.demo.app.util.SharedPrefsHelper
import saidur.demo.app.view.login.LoginScope

@Module
class SignupModule(private val mContext: Context) {

    @Provides
    @SignupScope
    internal fun provideContext(): Context {
        return this.mContext
    }

    @Provides
    @SignupScope
    internal fun provideSharedPrefsHelper(mContext: Context): SharedPrefsHelper {
        return SharedPrefsHelper(mContext)
    }
}