package com.example.dagger2car.model

import javax.inject.Inject

class Driver @Inject constructor(val name: String) {
    // Assume that Driver is part of a 3rd party library
}