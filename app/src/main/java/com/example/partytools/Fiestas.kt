package com.example.partytools

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import androidx.activity.enableEdgeToEdge

class Fiestas : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fiestas)

        // Inicializar FirebaseAuth
        auth = FirebaseAuth.getInstance()

        // Obtener el usuario actual
        val currentUser = auth.currentUser
        val welcomeTextView = findViewById<TextView>(R.id.textView2)

        // Verificar si el usuario actual tiene un nombre registrado y personalizar el mensaje
        val welcomeMessage = if (currentUser != null && currentUser.displayName != null) {
            "Bienvenido a la fiesta ${currentUser.displayName}"
        } else {
            "Bienvenido a la fiesta"
        }

        // Actualizar el texto del mensaje de bienvenida
        welcomeTextView.text = welcomeMessage

        // Botón para navegar a F_Cerca
        val buttonFiestasCerca = findViewById<Button>(R.id.button_fiestasCerca)
        buttonFiestasCerca.setOnClickListener {
            val intent = Intent(this, F_Cerca::class.java)
            startActivity(intent)
        }

        // Botón para navegar a F_Comunidad
        val buttonComReuniones = findViewById<Button>(R.id.button_ComReuniones)
        buttonComReuniones.setOnClickListener {
            val intent = Intent(this, F_Comunidad::class.java)
            startActivity(intent)
        }

        // Botón para ir a Juegos
        val iconoJuegosFiestas = findViewById<ImageView>(R.id.icono_juegos_fiestas)
        iconoJuegosFiestas.setOnClickListener {
            val intent = Intent(this, Juegos::class.java)
            startActivity(intent)
        }

        // Botón para ir a Alcohol
        val iconoAlcoholFiestas = findViewById<ImageView>(R.id.icono_alcohol_fiestas)
        iconoAlcoholFiestas.setOnClickListener {
            val intent = Intent(this, Alcohol::class.java)
            startActivity(intent)
        }

        // Botón para ir a Cocteles
        val iconoCoctelesFiestas = findViewById<ImageView>(R.id.icono_cocteles_fiestas)
        iconoCoctelesFiestas.setOnClickListener {
            val intent = Intent(this, Cocteles::class.java)
            startActivity(intent)
        }
        val btusuariofiestas = findViewById<ImageView>(R.id.usuario_fiestas)
        btusuariofiestas.setOnClickListener {
            val intent = Intent(this, Usuario::class.java)
            startActivity(intent)
        }
    }
}
