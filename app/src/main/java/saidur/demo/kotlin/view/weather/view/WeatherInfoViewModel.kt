package saidur.demo.kotlin.view.weather.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import saidur.demo.kotlin.retrofit.RequestCompleteListener
import saidur.demo.kotlin.retrofit.ServiceGenerator
import saidur.demo.kotlin.retrofit.endpoint.DemoEndPoint
import saidur.demo.kotlin.util.kelvinToCelsius
import saidur.demo.kotlin.util.unixTimestampToDateTimeString
import saidur.demo.kotlin.util.unixTimestampToTimeString
import saidur.demo.kotlin.view.weather.data.City
import saidur.demo.kotlin.view.weather.data.WeatherData
import saidur.demo.kotlin.view.weather.data.WeatherInfoResponse
import saidur.demo.kotlin.view.weather.model.WeatherInfoShowModel

class WeatherInfoViewModel : ViewModel() {

    private var endPoint: DemoEndPoint? = null
    private val disposable = CompositeDisposable()

    /**
     * In our project, for sake for simplicity we used different LiveData for success and failure.
     * But it's not the only way. We can use a wrapper data class to implement success and failure
     * both using a single LiveData. Another good approach may be handle errors in BaseActivity.
     * For this project our objective is only understand about MVVM. So we made it easy to understand.
     */
    val cityListLiveData = MutableLiveData<MutableList<City>>()
    val cityListFailureLiveData = MutableLiveData<String>()
    val weatherInfoLiveData = MutableLiveData<WeatherData>()
    val weatherInfoFailureLiveData = MutableLiveData<String>()
    val progressBarLiveData = MutableLiveData<Boolean>()

    /**We can inject the instance of Model in Constructor using dependency injection.
     * For sake of simplicity, I am ignoring it now. So we have to pass instance of model in every
     * methods of ViewModel. Please be noted, it's not a good approach.
     */
    fun getCityList(model: WeatherInfoShowModel) {

        model.getCityList(object :
            RequestCompleteListener<MutableList<City>> {
            override fun onRequestSuccess(data: MutableList<City>) {
                cityListLiveData.postValue(data) // PUSH data to LiveData object
            }

            override fun onRequestFailed(errorMessage: String) {
                cityListFailureLiveData.postValue(errorMessage) // PUSH error message to LiveData object
            }
        })
    }

    /**We can inject the instance of Model in Constructor using dependency injection.
     * For sake of simplicity, I am ignoring it now. So we have to pass instance of model in every
     * methods of ViewModel. Pleas be noted, it's not a good approach.
     */
    fun getWeatherInfo(cityId: Int, model: WeatherInfoShowModel) {

        progressBarLiveData.postValue(true) // PUSH data to LiveData object to show progress bar

        endPoint = ServiceGenerator.createService(DemoEndPoint::class.java)
        disposable.add(
            endPoint!!
                .callApiForWeatherInfo(cityId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<WeatherInfoResponse>() {
                    override fun onSuccess(weatherInfoResponse: WeatherInfoResponse) {
                        val weatherData = WeatherData(
                            dateTime = weatherInfoResponse.dt.unixTimestampToDateTimeString(),
                            temperature = weatherInfoResponse.main.temp.kelvinToCelsius().toString(),
                            cityAndCountry = "${weatherInfoResponse.name}, ${weatherInfoResponse.sys.country}",
                            weatherConditionIconUrl = "http://openweathermap.org/img/w/${weatherInfoResponse.weather[0].icon}.png",
                            weatherConditionIconDescription = weatherInfoResponse.weather[0].description,
                            humidity = "${weatherInfoResponse.main.humidity}%",
                            pressure = "${weatherInfoResponse.main.pressure} mBar",
                            visibility = "${weatherInfoResponse.visibility/1000.0} KM",
                            sunrise = weatherInfoResponse.sys.sunrise.unixTimestampToTimeString(),
                            sunset = weatherInfoResponse.sys.sunset.unixTimestampToTimeString()
                        )

                        progressBarLiveData.postValue(false) // PUSH data to LiveData object to hide progress bar

                        // After applying business logic and data manipulation, we push data to show on UI
                        weatherInfoLiveData.postValue(weatherData) // PUSH data to LiveData object
                    }

                    override fun onError(e: Throwable) {
                        //e.printStackTrace()
                        progressBarLiveData.postValue(false) // hide progress bar
                        weatherInfoFailureLiveData.postValue(e.message) // PUSH error message to LiveData object
                    }
                }))

        /*model.getWeatherInfo(cityId, object :
            RequestCompleteListener<WeatherInfoResponse> {
            override fun onRequestSuccess(data: WeatherInfoResponse) {

                // business logic and data manipulation tasks should be done here
                val weatherData = WeatherData(
                    dateTime = data.dt.unixTimestampToDateTimeString(),
                    temperature = data.main.temp.kelvinToCelsius().toString(),
                    cityAndCountry = "${data.name}, ${data.sys.country}",
                    weatherConditionIconUrl = "http://openweathermap.org/img/w/${data.weather[0].icon}.png",
                    weatherConditionIconDescription = data.weather[0].description,
                    humidity = "${data.main.humidity}%",
                    pressure = "${data.main.pressure} mBar",
                    visibility = "${data.visibility/1000.0} KM",
                    sunrise = data.sys.sunrise.unixTimestampToTimeString(),
                    sunset = data.sys.sunset.unixTimestampToTimeString()
                )

                progressBarLiveData.postValue(false) // PUSH data to LiveData object to hide progress bar

                // After applying business logic and data manipulation, we push data to show on UI
                weatherInfoLiveData.postValue(weatherData) // PUSH data to LiveData object
            }

            override fun onRequestFailed(errorMessage: String) {
                progressBarLiveData.postValue(false) // hide progress bar
                weatherInfoFailureLiveData.postValue(errorMessage) // PUSH error message to LiveData object
            }
        })*/
    }
}