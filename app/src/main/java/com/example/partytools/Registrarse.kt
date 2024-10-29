package com.example.partytools

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Registrarse : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registrarse)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configurar el OnClickListener para el botón de volver
        val volverButton = findViewById<Button>(R.id.volver_registrarse)
        volverButton.setOnClickListener {
            val intent = Intent(this, Main::class.java)
            startActivity(intent)
            finish() // Opcional: cerrar esta actividad si no quieres volver a ella
        }

        // Configurar el OnClickListener para el botón de registrarse
        val registrarseButton = findViewById<Button>(R.id.registrarse_registrarse)
        registrarseButton.setOnClickListener {
            val intent = Intent(this, Inicio::class.java) // Cambia a Inicio
            startActivity(intent)
            finish() // Opcional: cerrar esta actividad si no quieres volver a ella
        }
    }
}
