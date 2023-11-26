package kz.just_code.di_koin.data

import androidx.lifecycle.ViewModel
import kz.just_code.di_koin.data.useCases.GetCurrentWeatherUseCase
import kz.just_code.di_koin.data.useCases.SearchWeatherUseCase

class MainViewModel(
    private val getCurrentWeather: GetCurrentWeatherUseCase,
    private val searchWeather: SearchWeatherUseCase
): ViewModel() {

}