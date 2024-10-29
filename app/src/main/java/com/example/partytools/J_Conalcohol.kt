package com.example.partytools

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView

class J_Conalcohol : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_jconalcohol)

        // Boton Volver a Juegos
        val volverButton = findViewById<ImageView>(R.id.Volver_jconalcohol)
        volverButton.setOnClickListener {
            val intent = Intent(this, Juegos::class.java)
            startActivity(intent)
        }
    }
}
