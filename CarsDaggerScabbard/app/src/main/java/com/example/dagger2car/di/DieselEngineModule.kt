package com.example.dagger2car.di

import com.example.dagger2car.model.DieselEngine
import com.example.dagger2car.model.Engine
import dagger.Module
import dagger.Provides


@Module
class DieselEngineModule(val horsePower: Int) {
    @Provides
    fun provideEngine(): Engine = DieselEngine(horsePower)
}