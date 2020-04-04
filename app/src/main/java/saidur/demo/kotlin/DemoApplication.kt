package saidur.demo.kotlin

import android.content.Context

import androidx.multidex.MultiDexApplication


class DemoApplication : MultiDexApplication() {
    var appModule: DemoModule? = null
        private set
    var appComponent: DemoComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()

        instance = this
        appModule = DemoModule(this)
        appComponent = DaggerDemoComponent.builder()
            .demoModule(appModule)
            .build()
    }

    companion object {
        var instance: DemoApplication? = null
            private set

        fun getInstance(mContext: Context): DemoApplication {
            return mContext.applicationContext as DemoApplication
        }
    }
}
