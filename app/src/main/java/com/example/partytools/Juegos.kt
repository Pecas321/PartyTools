package com.example.partytools

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class Juegos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_juegos)

        // Botón a J_Demesa
        val buttonTquila = findViewById<Button>(R.id.Juegos_mesa)
        buttonTquila.setOnClickListener {
            val intent = Intent(this, J_Demesa::class.java)
            startActivity(intent)
        }

        // Botón a J_Conalcohol
        val buttonAlcohol = findViewById<Button>(R.id.Juegos_Alcohol)
        buttonAlcohol.setOnClickListener {
            val intent = Intent(this, J_Conalcohol::class.java)
            startActivity(intent)
        }

        // Botón a J_Descubre
        val buttonDescubre = findViewById<Button>(R.id.Descubre_juegos)
        buttonDescubre.setOnClickListener {
            val intent = Intent(this, J_Descubre::class.java)
            startActivity(intent)
        }
    }
}
