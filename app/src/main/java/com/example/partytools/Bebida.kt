package com.example.partytools

data class Bebida(
    val nombre: String,
    val imagenResId: Int, // ID de la imagen de la bebida en drawable
    val porcentajeAlcohol: String,
    val precio: String,
    val sabor: String,
    val coctelesRecomendados: String
)
