package com.example.partytools

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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
    }
}
