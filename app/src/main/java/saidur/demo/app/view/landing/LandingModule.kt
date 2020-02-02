package saidur.demo.app.view.landing

import android.content.Context

import dagger.Module
import dagger.Provides
import saidur.demo.app.util.SharedPrefsHelper

@Module
class LandingModule(private val mContext: Context) {

    @Provides
    @LandingScope
    internal fun provideContext(): Context {
        return this.mContext
    }

    @Provides
    @LandingScope
    internal fun provideSharedPrefsHelper(mContext: Context): SharedPrefsHelper {
        return SharedPrefsHelper(mContext)
    }
}