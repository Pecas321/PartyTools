package com.example.partytools

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Cocteles : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cocteles)

        // Botón para navegar a C_Recetas
        val buttonJuegosMesa = findViewById<Button>(R.id.button_Recetas)
        buttonJuegosMesa.setOnClickListener {
            val intent = Intent(this, C_Recetas::class.java)
            startActivity(intent)
        }

        // Botón para navegar a C_Sinalcohol
        val buttonJuegosAlcohol = findViewById<Button>(R.id.button_sinalcohol)
        buttonJuegosAlcohol.setOnClickListener {
            val intent = Intent(this, C_Sinalcohol::class.java)
            startActivity(intent)
        }

        // Botón para ir a Fiestas
        val iconoFiestasCocteles = findViewById<ImageView>(R.id.icono_fiesta_cocteles)
        iconoFiestasCocteles.setOnClickListener {
            val intent = Intent(this, Fiestas::class.java)
            startActivity(intent)
        }

        // Botón para ir a Alcohol
        val iconoAlcoholCocteles = findViewById<ImageView>(R.id.icono_alcohol_cocteles)
        iconoAlcoholCocteles.setOnClickListener {
            val intent = Intent(this, Alcohol::class.java)
            startActivity(intent)
        }

        // Botón para ir a Juegos
        val iconoJuegosCocteles = findViewById<ImageView>(R.id.icono_juegos_cocteles)
        iconoJuegosCocteles.setOnClickListener {
            val intent = Intent(this, Juegos::class.java)
            startActivity(intent)
        }
    }
}
