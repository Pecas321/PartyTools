package com.example.partytools

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Chapinero : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chapinero)

        // Configura el ImageView para volver a la actividad Fiestas
        val buttonVolver = findViewById<ImageView>(R.id.Volver_CHAPINERO)
        buttonVolver.setOnClickListener {
            val intent = Intent(this, F_Cerca::class.java)
            startActivity(intent)
        }
    }
}