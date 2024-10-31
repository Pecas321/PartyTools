package com.example.partytools

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio)


        val buttonJuegos = findViewById<Button>(R.id.buttonJuegos)
        buttonJuegos.setOnClickListener {
            val intent = Intent(this, Juegos::class.java) // Cambia a Juegos
            startActivity(intent)
        }
        val buttonCocteles = findViewById<Button>(R.id.buttonCocteles)
        buttonCocteles.setOnClickListener {
            val intent = Intent(this, Cocteles::class.java)
            startActivity(intent)
        }
        val buttonFiestas = findViewById<Button>(R.id.buttonFiestas)
        buttonFiestas.setOnClickListener {
            val intent = Intent(this, Fiestas::class.java)
            startActivity(intent)
        }
        val buttonAlcoholSeguro = findViewById<Button>(R.id.buttonAlcohol)
        buttonAlcoholSeguro.setOnClickListener {
            val intent = Intent(this, Alcohol::class.java)
            startActivity(intent)
        }
    }
}
