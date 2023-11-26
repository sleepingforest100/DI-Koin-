package kz.just_code.di_koin

import android.app.Application
import kz.just_code.di_koin.data.modules.networkModule
import kz.just_code.di_koin.data.modules.repositoryModule
import kz.just_code.di_koin.data.modules.useCaseModule
import kz.just_code.di_koin.data.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class KoinApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@KoinApplication)
            modules(
                networkModule,
                useCaseModule,
                repositoryModule,
                viewModelModule

            )
        }
    }
}