package com.example.partytools

data class RegistroBebida(
    var tipoBebida: String? = null,
    var fecha: String? = null,
    var peso: Double? = null,
    var cantidad: Double? = null,
    var graduacion: Double? = null,
    var bac: Double? = null,
    var recomendacion: String? = null,
    var userId: String? = null // Campo agregado para identificar al usuario
) {
    // Constructor vacío requerido por Firebase
    constructor() : this(null, null, null, null, null, null, null, null)
}
