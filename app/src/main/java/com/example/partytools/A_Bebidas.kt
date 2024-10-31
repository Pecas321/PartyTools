package com.example.partytools

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView

class A_Bebidas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_abebidas)

        // Configurar el botón para volver a Alcohol
        val volverButton = findViewById<ImageView>(R.id.Volver_abebidas)
        volverButton.setOnClickListener {
            val intent = Intent(this, Alcohol::class.java)
            startActivity(intent)
            finish() // Opcional: Finaliza A_Bebidas para que no vuelva al apretar atrás
        }
    }
}
