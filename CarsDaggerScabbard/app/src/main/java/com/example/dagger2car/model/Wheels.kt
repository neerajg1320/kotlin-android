package com.example.dagger2car.model

import com.example.dagger2car.model.Rims
import com.example.dagger2car.model.Tyres
import javax.inject.Inject

class Wheels @Inject constructor(val rims: Rims, val tyres: Tyres) {
}