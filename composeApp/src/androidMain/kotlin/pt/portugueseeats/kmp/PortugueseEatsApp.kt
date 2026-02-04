package pt.portugueseeats.kmp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import pt.portugueseeats.kmp.di.initKoin


class PortugueseEatsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@PortugueseEatsApp)
        }
    }
}