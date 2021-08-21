package com.example.dagger2car.di

import com.example.dagger2car.model.Car
import com.example.dagger2car.MainActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import javax.inject.Named


@PerActivity
//@Component(
//    dependencies = [
//        ApplicationComponent::class
//    ],
//    modules = [
//        WheelsModule::class,
//        PetrolEngineModule::class
//    ]
//)
@Subcomponent(
    modules = [
        WheelsModule::class,
        PetrolEngineModule::class
    ]
)
interface CarComponent {
    fun getCar(): Car

    fun inject (mainActivity: MainActivity)

//    @Component.Builder
//    interface Builder {
//        // Author: The name of function should match the variable to be injected
//        // This was not necessary. This can be a function name
//        @BindsInstance
//        fun horsePowerFunction(@Named("horsePower") hp: Int): Builder
//
//        @BindsInstance
//        fun engineCapacity(@Named("engineCapacity") cap:Int): Builder
//
//        fun getApplicationComponent(appComponent: ApplicationComponent): Builder
//
//        fun build(): CarComponent
//    }

//    @Subcomponent.Builder
//    interface  Builder{
//                @BindsInstance
//        fun horsePowerFunction(@Named("horsePower") hp: Int): Builder
//
//        @BindsInstance
//        fun engineCapacity(@Named("engineCapacity") cap:Int): Builder
//
//        fun build(): CarComponent
//    }

    @Subcomponent.Factory
    interface Factory {
        fun create(
                @BindsInstance @Named("horsePower") hp:Int,
                @BindsInstance @Named("engineCapacity") cap:Int
        ): CarComponent
    }
}