package com.example.partytools

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class Juegos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_juegos)

        // Obtener el usuario autenticado de Firebase
        val user = FirebaseAuth.getInstance().currentUser
        val nombreUsuario = user?.displayName

        // Mostrar el nombre del usuario en el TextView correspondiente
        val textViewSaludo = findViewById<TextView>(R.id.Juegodemesa)
        textViewSaludo.text = "Hola $nombreUsuario ¡Diviértete con nuestros juegos!"

        // Botón a J_Demesa
        val buttonTquila = findViewById<Button>(R.id.button_Recetas)
        buttonTquila.setOnClickListener {
            val intent = Intent(this, J_Demesa::class.java)
            startActivity(intent)
        }

        // Botón a J_Conalcohol
        val buttonAlcohol = findViewById<Button>(R.id.button_sinalcohol)
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

        // Botón para ir a Fiestas
        val iconoFiestasJuegos = findViewById<ImageView>(R.id.icono_fiesta_juegos)
        iconoFiestasJuegos.setOnClickListener {
            val intent = Intent(this, Fiestas::class.java)
            startActivity(intent)
        }

        // Botón para ir a Alcohol
        val iconoAlcoholJuegos = findViewById<ImageView>(R.id.icono_alcohol_juegos)
        iconoAlcoholJuegos.setOnClickListener {
            val intent = Intent(this, Alcohol::class.java)
            startActivity(intent)
        }

        // Botón para ir a Cocteles
        val iconoCoctelesJuegos = findViewById<ImageView>(R.id.icono_cocteles_juegos)
        iconoCoctelesJuegos.setOnClickListener {
            val intent = Intent(this, Cocteles::class.java)
            startActivity(intent)
        }
    }
}
