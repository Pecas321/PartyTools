package com.example.partytools

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio)

        // Referencia al botón "Fiestas"
        val buttonFiestas = findViewById<Button>(R.id.buttonFiestas)
        buttonFiestas.setOnClickListener {
            val intent = Intent(this, Fiesta::class.java)
            startActivity(intent)
        }

        // Botón para Juegos
        val buttonJuegos = findViewById<Button>(R.id.buttonJuegos)
        buttonJuegos.setOnClickListener {
            val intent = Intent(this, juegos::class.java)
            startActivity(intent)
        }

        // Botón para Cocteles
        val buttonCocteles = findViewById<Button>(R.id.buttonCocteles)
        buttonCocteles.setOnClickListener {
            val intent = Intent(this, Cocteles::class.java)
            startActivity(intent)
        }

        // Botón para Alcohol Seguro
        val buttonAlcoholSeguro = findViewById<Button>(R.id.buttonAlcoholSeguro)
        buttonAlcoholSeguro.setOnClickListener {
            val intent = Intent(this, Alcoholseguro::class.java)
            startActivity(intent)
        }
    }
}
