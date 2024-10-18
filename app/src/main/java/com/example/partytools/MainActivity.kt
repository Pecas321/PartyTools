package com.example.partytools

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val buttonIniciarSesion = findViewById<Button>(R.id.iniciarsesion_inicio)
        buttonIniciarSesion.setOnClickListener {
            val intent = Intent(this, InicioSesion::class.java)
            startActivity(intent)
        }

        // Configurar el OnClickListener para el botón de registrarse
        val buttonRegistrarse = findViewById<Button>(R.id.registrarse_main)
        buttonRegistrarse.setOnClickListener {
            val intent = Intent(this, Registrarse::class.java) // Cambia a Registrarse
            startActivity(intent)
        }
    }
}
