package saidur.demo.app.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import saidur.demo.app.DemoApplication
import saidur.demo.app.util.Config

object ServiceGenerator {

    private val API_BASE_URL = Config.DEV_URL
    private val cacheSize = 10 * 1024 * 1024 // 10 MB

    //private val cache = Cache(DemoApplication.getInstance().cacheDir, cacheSize.toLong())

    private val okHttpClient = OkHttpClient.Builder()
        //.cache(cache)
        .build()

    private val gson = GsonBuilder()
        .setLenient()
        .create()

    private val builder = Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .client(okHttpClient)  //getUnsafeOkHttpClient().build()//okHttpClient
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))

    private val retrofit = builder.build()

    fun <S> createService(serviceClass: Class<S>): S {
        return retrofit.create(serviceClass)
    }
}
