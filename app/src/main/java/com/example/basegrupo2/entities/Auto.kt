package com.example.basegrupo2.entities

class Auto(marca: String?, cilindrada: Int?, color: String?) {
    var marca: String = ""
    var color: String = ""
    var cilindrada: Int = 0

    init {
        this.marca = marca!!
        this.cilindrada = cilindrada!!
        this.color = color!!
    }
}