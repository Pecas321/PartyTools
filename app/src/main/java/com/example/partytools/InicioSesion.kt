package com.example.partytools

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InicioSesion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio_sesion)

        // Botón "Registrarse" para volver a MainActivity
        val volver_iniciosesion = findViewById<Button>(R.id.registrarse_main)
        volver_iniciosesion.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Cierra la actividad actual
        }

        // Botón "Iniciar Sesión" para ir a Inicio.kt
        val iniciarSesionButton = findViewById<Button>(R.id.iniciarsesion_inicio)
        iniciarSesionButton.setOnClickListener {
            val intent = Intent(this, Inicio::class.java)
            startActivity(intent)
        }
    }
}
