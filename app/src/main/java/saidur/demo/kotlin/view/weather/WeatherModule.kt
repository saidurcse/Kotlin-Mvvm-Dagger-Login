package saidur.demo.kotlin.view.weather

import android.content.Context

import dagger.Module
import dagger.Provides
import saidur.demo.kotlin.util.SharedPrefsHelper

@Module
class WeatherModule(private val mContext: Context) {

    @Provides
    @WeatherScope
    internal fun provideContext(): Context {
        return this.mContext
    }

    @Provides
    @WeatherScope
    internal fun provideSharedPrefsHelper(mContext: Context): SharedPrefsHelper {
        return SharedPrefsHelper(mContext)
    }
}