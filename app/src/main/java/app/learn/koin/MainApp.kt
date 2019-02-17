package app.learn.koin

import android.app.Application
import app.learn.koin.koin.appComponent
import org.koin.android.ext.android.startKoin

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, appComponent)
    }
}