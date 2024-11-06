package com.example.partytools

data class JuegoDescubre(
    var nombre: String = "",
    var numeroJugadores: Int = 0,
    var edad: Int = 0,
    var reglas: String = "",
    var descripcion: String = ""
) {
    // Constructor vacío requerido por Firebase
    constructor() : this("", 0, 0, "", "")
}
