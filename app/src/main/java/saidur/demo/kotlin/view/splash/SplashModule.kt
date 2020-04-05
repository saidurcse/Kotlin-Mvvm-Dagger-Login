package saidur.demo.kotlin.view.splash

import android.content.Context

import dagger.Module
import dagger.Provides
import saidur.demo.kotlin.util.SharedPrefsHelper

@Module
class SplashModule(private val mContext: Context) {

    @Provides
    @SplashScope
    internal fun provideContext(): Context {
        return this.mContext
    }

    @Provides
    @SplashScope
    internal fun provideSharedPrefsHelper(mContext: Context): SharedPrefsHelper {
        return SharedPrefsHelper(mContext)
    }
}