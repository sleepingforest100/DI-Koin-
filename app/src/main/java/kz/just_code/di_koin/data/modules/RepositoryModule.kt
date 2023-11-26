package kz.just_code.di_koin.data.modules

import kz.just_code.di_koin.data.repositories.provideWeatherRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { provideWeatherRepository(api = get()) }
}