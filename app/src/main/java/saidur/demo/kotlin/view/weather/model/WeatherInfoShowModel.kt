package saidur.demo.kotlin.view.weather.model

import saidur.demo.kotlin.retrofit.RequestCompleteListener
import saidur.demo.kotlin.view.weather.data.City
import saidur.demo.kotlin.view.weather.data.WeatherInfoResponse

interface WeatherInfoShowModel {
    fun getCityList(callback: RequestCompleteListener<MutableList<City>>)
    fun getWeatherInfo(cityId: Int, callback: RequestCompleteListener<WeatherInfoResponse>)
}