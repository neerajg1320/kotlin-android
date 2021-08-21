package com.example.dagger2car.di

import com.example.dagger2car.model.Driver
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DriverModule(val name:String) {
    @Singleton
    @Provides
    fun driver(): Driver = Driver(name)
}