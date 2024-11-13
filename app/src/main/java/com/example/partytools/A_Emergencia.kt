package com.example.partytools

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class A_Emergencia : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_aemergencia)

        // Configurar el botón para volver a Alcohol
        val volverButton = findViewById<ImageView>(R.id.Volver_aemergencia)
        volverButton.setOnClickListener {
            val intent = Intent(this, Alcohol::class.java)
            startActivity(intent)
            finish() // Opcional: Finaliza A_Emergencia para que no vuelva al apretar atrás
        }

        // Configurar el botón para llamar a emergencias
        val llamarButton = findViewById<Button>(R.id.btnLlamarEmergencias)
        llamarButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:123") // Número de emergencias en Colombia
            }
            startActivity(intent)
        }
    }
}
