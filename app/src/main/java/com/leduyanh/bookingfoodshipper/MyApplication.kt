package com.leduyanh.bookingfoodshipper

import android.app.Application
import android.content.Context
import com.leduyanh.bookingfoodshipper.di.viewModelModule
import io.socket.client.IO
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class MyApplication: Application() {

    companion object {

        val mSocket = IO.socket(MyApplication.URL+"/")
        //mSocket.connect()

        const val URL = "http://192.168.43.22:4000"

        lateinit var instance: MyApplication

        fun applicationContext(): Context? {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        mSocket.connect()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(viewModelModule)
        }
    }
}