    package com.example.partytools

    data class Comunidad(
        var titulo: String = "",
        var numeroParticipantes: Int = 0,
        var descripcion: String = ""
    ) {
        // Constructor vacío requerido por Firebase
        constructor() : this("", 0, "")
    }
