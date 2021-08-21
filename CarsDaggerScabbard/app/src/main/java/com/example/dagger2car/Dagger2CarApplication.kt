package com.example.dagger2car

import android.app.Application
import com.example.dagger2car.di.ApplicationComponent
import com.example.dagger2car.di.CarComponent
import com.example.dagger2car.di.DaggerApplicationComponent
import com.example.dagger2car.di.DriverModule


class Dagger2CarApplication: Application() {
//    lateinit var carComponent: CarComponent

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerApplicationComponent.factory().create(DriverModule("John"))

//        appComponent = DaggerApplicationComponent.create()

//        carComponent = DaggerCarComponent
//            .builder()
//            .horsePowerFunction(150)
//            .engineCapacity(1400)
//            .build()
    }
}