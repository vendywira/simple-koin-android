package app.learn.koin.koin

import app.learn.koin.presentation.activity.MainPresenter
import com.google.gson.Gson
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val appModule = module {
    single { Gson() }
    factory { MainPresenter(androidContext(), get()) }
}