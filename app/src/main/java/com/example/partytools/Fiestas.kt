package com.example.partytools

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge

class Fiestas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fiestas)

        // Botón para navegar a F_Cerca
        val buttonFiestasCerca = findViewById<Button>(R.id.button_fiestasCerca)
        buttonFiestasCerca.setOnClickListener {
            val intent = Intent(this, F_Cerca::class.java)
            startActivity(intent)
        }

        // Botón para navegar a F_Comunidad
        val buttonComReuniones = findViewById<Button>(R.id.button_ComReuniones)
        buttonComReuniones.setOnClickListener {
            val intent = Intent(this, F_Comunidad::class.java)
            startActivity(intent)
        }
    }
}
