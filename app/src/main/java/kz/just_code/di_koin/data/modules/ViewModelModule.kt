package kz.just_code.di_koin.data.modules

import kz.just_code.di_koin.data.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainViewModel(getCurrentWeather = get(), searchWeather = get())
    }
}