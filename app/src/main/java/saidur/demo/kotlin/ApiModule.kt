package saidur.demo.kotlin

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

import java.util.concurrent.TimeUnit

import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import saidur.demo.kotlin.retrofit.endpoint.DemoEndPoint
import saidur.demo.kotlin.util.Config

@Module
class ApiModule {
    private val PRODUCTION_API_URL = HttpUrl.parse(Config.DEV_URL)

    @Provides
    @DemoScope
    internal fun provideBaseUrl(): HttpUrl? {
        return PRODUCTION_API_URL
    }

    @Provides
    @DemoScope
    internal fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @DemoScope
    internal fun provideRetrofit(mBaseUrl: HttpUrl, mClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .client(mClient)
            .baseUrl(mBaseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @DemoScope
    internal fun provideApiService(mRetrofit: Retrofit): DemoEndPoint {
        return mRetrofit.create(DemoEndPoint::class.java)
    }
}
