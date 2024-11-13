package com.example.partytools

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class Cocteles : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cocteles)

        // Obtener el usuario autenticado de Firebase
        val user = FirebaseAuth.getInstance().currentUser
        val nombreUsuario = user?.displayName

        // Mostrar el nombre del usuario en el TextView correspondiente
        val textViewSaludo = findViewById<TextView>(R.id.Juegodemesa)
        textViewSaludo.text = "Hola $nombreUsuario ¡Descubre deliciosos cocteles!"

        // Botón para navegar a C_Recetas
        val buttonJuegosMesa = findViewById<Button>(R.id.button_Recetas)
        buttonJuegosMesa.setOnClickListener {
            val intent = Intent(this, C_Recetas::class.java)
            startActivity(intent)
        }

        // Botón para navegar a C_Sinalcohol
        val buttonJuegosAlcohol = findViewById<Button>(R.id.button_sinalcohol)
        buttonJuegosAlcohol.setOnClickListener {
            val intent = Intent(this, C_Sinalcohol::class.java)
            startActivity(intent)
        }

        // Botón para ir a Fiestas
        val iconoFiestasCocteles = findViewById<ImageView>(R.id.icono_fiesta_cocteles)
        iconoFiestasCocteles.setOnClickListener {
            val intent = Intent(this, Fiestas::class.java)
            startActivity(intent)
        }

        // Botón para ir a Alcohol
        val iconoAlcoholCocteles = findViewById<ImageView>(R.id.icono_alcohol_cocteles)
        iconoAlcoholCocteles.setOnClickListener {
            val intent = Intent(this, Alcohol::class.java)
            startActivity(intent)
        }

        // Botón para ir a Juegos
        val iconoJuegosCocteles = findViewById<ImageView>(R.id.icono_juegos_cocteles)
        iconoJuegosCocteles.setOnClickListener {
            val intent = Intent(this, Juegos::class.java)
            startActivity(intent)
        }
        val btusuariococteles = findViewById<ImageView>(R.id.usuario_cocteles)
        btusuariococteles.setOnClickListener {
            val intent = Intent(this, Usuario::class.java)
            startActivity(intent)
        }
    }
}
