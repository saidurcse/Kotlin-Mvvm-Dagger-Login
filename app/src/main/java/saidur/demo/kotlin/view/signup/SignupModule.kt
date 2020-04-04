package saidur.demo.kotlin.view.signup

import android.content.Context

import dagger.Module
import dagger.Provides
import saidur.demo.kotlin.util.SharedPrefsHelper

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