package saidur.demo.kotlin.retrofit.endpoint

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import saidur.demo.kotlin.view.weather.data.WeatherInfoResponse

interface DemoEndPoint {
    /*@POST("registeredUser/login")
    Single<RegisteredLoginResponse> getRegisteredUserLogin(@Body RegisteredLoginRequest registeredUserLogin);*/
    @GET("weather")
    fun callApiForWeatherInfo(@Query("id") cityId: Int): Call<WeatherInfoResponse>
}
