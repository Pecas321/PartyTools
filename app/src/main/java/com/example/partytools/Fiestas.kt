package com.example.partytools

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import androidx.activity.enableEdgeToEdge

class Fiestas : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fiestas)

        // Encontrar el botón por su ID
        val buttonFiestasCerca = findViewById<Button>(R.id.button_fiestasCerca)

        // Asignar la acción para iniciar la nueva actividad
        buttonFiestasCerca.setOnClickListener {
            val intent = Intent(this, F_Cerca::class.java)
            startActivity(intent)
        }
    }
}
