package kz.just_code.di_koin.data.repositories

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import kz.just_code.di_koin.data.network.CurrentWeather
import kz.just_code.di_koin.data.network.WeatherApi
import kz.just_code.di_koin.data.network.WeatherApiError
import kz.just_code.di_koin.data.network.WeatherResponse
import okhttp3.ResponseBody

interface WeatherRepository {
    suspend fun getCurrentWeather(city: String): WeatherResponse?
    suspend fun searchWeather(text: String): WeatherResponse?
    suspend fun getWeeklyWeather(city: String): WeatherResponse?
}

class WeatherRepositoryImpl(
    private val api: WeatherApi
) : WeatherRepository {
    override suspend fun getCurrentWeather(city: String): WeatherResponse? {
        val response = api.getCurrentWeather(city, "ru")
        if (response.isSuccessful) return response.body()
        else throw Exception(response.errorBody().getErrorMessage())
    }

    override suspend fun searchWeather(text: String): WeatherResponse? {
        val response = api.searchWeather(text, "ru")
        if (response.isSuccessful) return response.body()
        else throw Exception(response.errorBody().getErrorMessage())
    }

    override suspend fun getWeeklyWeather(city: String): WeatherResponse? {
        val response = api.getWeeklyWeather(city, "ru")
        if (response.isSuccessful) return response.body()
        else throw Exception(response.errorBody().getErrorMessage())
    }


}

fun provideWeatherRepository(api: WeatherApi): WeatherRepository = WeatherRepositoryImpl(api)

fun ResponseBody?.getErrorMessage(): String? {
    return try {
        Gson().fromJson(this?.charStream(), WeatherApiError::class.java)?.error?.message
    } catch (e: Exception) {
        e.message.orEmpty()
    }
}