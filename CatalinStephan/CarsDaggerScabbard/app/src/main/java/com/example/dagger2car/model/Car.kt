package com.example.dagger2car.model

import android.util.Log
import com.example.dagger2car.di.PerActivity
import javax.inject.Inject

const val TAG = "DaggerCar"

@PerActivity
class Car @Inject constructor(var wheels: Wheels, val engine: Engine, val driver: Driver) {
    fun drive() {
        engine.start()
        Log.d(TAG, "$driver ${driver.name} is driving $this")
    }

    // Method Injection
    @Inject
    fun connectRemote(remote: Remote) {
        remote.enableRemote(this)
    }
}