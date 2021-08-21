package com.example.dagger2car.di

import com.example.dagger2car.model.Rims
import com.example.dagger2car.model.Tyres
import com.example.dagger2car.model.Wheels
import dagger.Module
import dagger.Provides

@Module
class WheelsModule {
    @Provides
    fun provideRims() = Rims()

    @Provides
    fun provideTyres(): Tyres {
        val tyres = Tyres()
        tyres.inflateTyres()
        return tyres
    }

    @Provides
    fun providesWheels(rims: Rims, tyres: Tyres) =
        Wheels(rims, tyres)
}