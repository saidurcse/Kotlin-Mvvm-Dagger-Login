package saidur.demo.app.view.login

import android.content.Context

import dagger.Module
import dagger.Provides
import saidur.demo.app.util.SharedPrefsHelper

@Module
class LoginModule(private val mContext: Context) {

    @Provides
    @LoginScope
    internal fun provideContext(): Context {
        return this.mContext
    }

    @Provides
    @LoginScope
    internal fun provideSharedPrefsHelper(mContext: Context): SharedPrefsHelper {
        return SharedPrefsHelper(mContext)
    }
}