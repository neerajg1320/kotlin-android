package com.example.dagger2car

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dagger2car.model.Car
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var car1: Car

    @Inject
    lateinit var car2: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // var carComponent = DaggerCarComponent.create()
        // val car = carComponent.getCar()

        // Since DieselEngineModule requires an input
        // Now moved to Application
//        val carComponent: CarComponent = DaggerCarComponent
//            .builder()
//            .horsePowerFunction(150)
//            .engineCapacity(1400)
//            .build()
//        // Following way for field injection
//        carComponent.inject(this)

//        (applicationContext as Dagger2CarApplication).carComponent.inject(this)

//        val carComponent = DaggerCarComponent.builder()
//            .horsePowerFunction(150)
//            .engineCapacity(1400)
//            .getApplicationComponent((applicationContext as Dagger2CarApplication).appComponent)
//            .build()
//
//        carComponent.inject(this)

//        (applicationContext as Dagger2CarApplication).appComponent
//                .getCarComponent(DieselEngineModule(120))
//                .inject(this)

//        (applicationContext as Dagger2CarApplication).appComponent
//                .getCarComponentBuilder()
//                .horsePowerFunction(120)
//                .engineCapacity(1400)
//                .build()
//                .inject(this)

        (applicationContext as Dagger2CarApplication).appComponent
                .getCarComponentFactory()
                .create(100, 1300)
                .inject(this)

        car1.drive()

        car2.drive()
    }
}