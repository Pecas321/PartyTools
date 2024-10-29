package com.example.partytools

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView

class J_Demesa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_juegosdemesa)

        // Boton volver a Juegos
        val volverButton = findViewById<ImageView>(R.id.Volver_juegosdemesa)
        volverButton.setOnClickListener {
            val intent = Intent(this, Juegos::class.java)
            startActivity(intent)
        }
    }
}
