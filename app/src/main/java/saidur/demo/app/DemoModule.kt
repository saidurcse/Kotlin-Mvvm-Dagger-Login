package saidur.demo.app

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

import com.google.gson.Gson

import dagger.Module
import dagger.Provides
import saidur.demo.app.model.DaggerTestClass
import saidur.demo.app.model.ObjectManager

@Module
class DemoModule(private val context: Context) {

    @DemoScope
    @Provides
    fun provideContext(): Context {
        return context
    }

    @DemoScope
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @DemoScope
    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    @DemoScope
    @Provides
    fun provideObjectManager(sharedPreferences: SharedPreferences, gson: Gson): ObjectManager {
        return ObjectManager(sharedPreferences, gson)
    }

    @Provides
    @DemoScope
    internal fun provideDaggerTestClass(): DaggerTestClass {
        return DaggerTestClass()
    }
}
