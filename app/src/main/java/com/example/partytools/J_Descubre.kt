package com.example.partytools

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView

class J_Descubre : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_jdescubre)

        // Inicializar el ImageView
        val volverButton = findViewById<ImageView>(R.id.Volver_jdescubre)

        // Configurar el listener para el ImageView
        volverButton.setOnClickListener {
            // Iniciar la actividad Juegos
            val intent = Intent(this, Juegos::class.java)
            startActivity(intent)
        }
    }
}
