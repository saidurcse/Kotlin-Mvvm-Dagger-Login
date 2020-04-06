package saidur.demo.kotlin.view.weather

import dagger.Component
import saidur.demo.kotlin.DemoComponent
import saidur.demo.kotlin.view.weather.model.WeatherInfoShowModel

@WeatherScope
@Component(dependencies = [DemoComponent::class], modules = [WeatherModule::class])
interface WeatherComponent : WeatherGraph {

    fun inject(weatherActivity: WeatherActivity)

    fun inject(weatherInfoShowModel: WeatherInfoShowModel)
}