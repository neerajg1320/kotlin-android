package com.example.dagger2car.model

import android.util.Log
import com.example.dagger2car.model.Car
import com.example.dagger2car.model.TAG
import javax.inject.Inject

class Remote @Inject constructor() {
    companion object
    fun enableRemote(car: Car) {
        Log.d(TAG, "Remote is connected to car: $car")
    }
}