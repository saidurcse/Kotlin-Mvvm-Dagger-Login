package saidur.demo.kotlin.retrofit.endpoint

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import saidur.demo.kotlin.view.weather.data.WeatherInfoResponse

interface DemoEndPoint {
    @GET("weather")
    fun callApiForWeatherInfo(@Query("id") cityId: Int): Single<WeatherInfoResponse>
    /*@GET("weather")
    fun callApiForWeatherInfo(@Query("id") cityId: Int): Call<WeatherInfoResponse>*/
}
