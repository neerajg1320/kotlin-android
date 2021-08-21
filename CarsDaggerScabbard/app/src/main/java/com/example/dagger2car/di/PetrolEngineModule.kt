package com.example.dagger2car.di

import com.example.dagger2car.model.Engine
import com.example.dagger2car.model.PetrolEngine
import dagger.Binds
import dagger.Module
//import dagger.Provides

//@Module
//class EngineModule {
//    @Provides
//    fun provideEngine(engine: PetrolEngine): Engine = engine
//}

@Module
abstract class PetrolEngineModule {
    @Binds
    abstract  fun bindEngine(engine: PetrolEngine): Engine
}