package kz.just_code.di_koin.data.useCases

import kz.just_code.di_koin.data.network.WeatherResponse
import kz.just_code.di_koin.data.repositories.WeatherRepository

interface GetCurrentWeatherUseCase {
    suspend fun execute(city: String): WeatherResponse?
}

class GetCurrentWeatherInteraction(
    private val repo: WeatherRepository
) : GetCurrentWeatherUseCase {
    override suspend fun execute(city: String): WeatherResponse? {
        return repo.getCurrentWeather(city)
    }
}

fun provideSearchWeatherUseCase(repo: WeatherRepository): SearchWeatherUseCase =
    SearchWeatherInteraction(repo)

interface SearchWeatherUseCase {
    suspend fun execute(text: String): WeatherResponse?
}

class SearchWeatherInteraction(
    private val repo: WeatherRepository
) : SearchWeatherUseCase {
    override suspend fun execute(text: String): WeatherResponse? {
        return repo.searchWeather(text)
    }
}

fun GetWeeklyWeatherUseCase(repo: WeatherRepository): GetWeeklyWeatherUseCase =
    GetWeeklyWeatherInteraction(repo)

interface GetWeeklyWeatherUseCase {
    suspend fun execute(city: String): WeatherResponse?
}

class GetWeeklyWeatherInteraction(
    private val repo: WeatherRepository
) : GetWeeklyWeatherUseCase {
    override suspend fun execute(city: String): WeatherResponse? {
        return repo.getWeeklyWeather(city)
    }
}

fun provideGetCurrentWeatherUseCase(repo: WeatherRepository): GetCurrentWeatherUseCase =
    GetCurrentWeatherInteraction(repo)
