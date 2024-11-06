package com.example.partytools

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView

class Alcohol : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alcohol)

        // Botón para ir a la calculadora
        val buttonCalculadora = findViewById<Button>(R.id.button_calculadora)
        buttonCalculadora.setOnClickListener {
            val intent = Intent(this, A_Calculadora::class.java)
            startActivity(intent)
        }

        // Botón para ir a A_Bebidas
        val buttonBebidas = findViewById<Button>(R.id.button_bebidas)
        buttonBebidas.setOnClickListener {
            val intent = Intent(this, A_Bebidas::class.java)
            startActivity(intent)
        }

        // Botón para ir a A_Emergencia
        val buttonEmergencias = findViewById<Button>(R.id.Button_emergencias)
        buttonEmergencias.setOnClickListener {
            val intent = Intent(this, A_Emergencia::class.java)
            startActivity(intent)
        }

        // Botón para ir a Juegos
        val iconoJuegosAlcohol = findViewById<ImageView>(R.id.icono_juegos_alcohol)
        iconoJuegosAlcohol.setOnClickListener {
            val intent = Intent(this, Juegos::class.java)
            startActivity(intent)
        }

        // Botón para ir a Fiestas
        val iconoFiestaAlcohol = findViewById<ImageView>(R.id.icono_fiesta_alcohol)
        iconoFiestaAlcohol.setOnClickListener {
            val intent = Intent(this, Fiestas::class.java)
            startActivity(intent)
        }

        // Botón para ir a Cocteles
        val iconoCoctelesAlcohol = findViewById<ImageView>(R.id.icono_cocteles_alcohol)
        iconoCoctelesAlcohol.setOnClickListener {
            val intent = Intent(this, Cocteles::class.java)
            startActivity(intent)
        }
    }
}
