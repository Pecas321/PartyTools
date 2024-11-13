package com.example.partytools

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class Inicio : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio)

        // Inicializa Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Obtén el nombre del usuario autenticado
        val currentUser = auth.currentUser
        val nombreUsuario = currentUser?.displayName

        // Actualiza el TextView con el nombre del usuario
        val textViewCabito = findViewById<TextView>(R.id.textViewCabito)
        textViewCabito.text = nombreUsuario ?: "Invitado"  // Si el nombre es nulo, muestra "Invitado"

        // Configuración de botones de navegación
        val buttonJuegos = findViewById<Button>(R.id.buttonJuegos)
        buttonJuegos.setOnClickListener {
            val intent = Intent(this, Juegos::class.java) // Cambia a Juegos
            startActivity(intent)
        }

        val buttonCocteles = findViewById<Button>(R.id.buttonCocteles)
        buttonCocteles.setOnClickListener {
            val intent = Intent(this, Cocteles::class.java)
            startActivity(intent)
        }

        val buttonFiestas = findViewById<Button>(R.id.buttonFiestas)
        buttonFiestas.setOnClickListener {
            val intent = Intent(this, Fiestas::class.java)
            startActivity(intent)
        }

        val buttonAlcoholSeguro = findViewById<Button>(R.id.buttonAlcohol)
        buttonAlcoholSeguro.setOnClickListener {
            val intent = Intent(this, Alcohol::class.java)
            startActivity(intent)
        }

        // Configuración del ImageView para redirigir a Usuario.kt
        val imageViewUsuario = findViewById<ImageView>(R.id.usuario_inicio)
        imageViewUsuario.setOnClickListener {
            val intent = Intent(this, Usuario::class.java) // Redirige a Usuario.kt
            startActivity(intent)
        }
    }
}
