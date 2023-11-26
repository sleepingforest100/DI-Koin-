package kz.just_code.di_koin.data.modules

import kz.just_code.di_koin.data.useCases.provideGetCurrentWeatherUseCase
import kz.just_code.di_koin.data.useCases.provideSearchWeatherUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory {
        provideGetCurrentWeatherUseCase(get())
    }
    factory {
        provideSearchWeatherUseCase(get())
    }
}