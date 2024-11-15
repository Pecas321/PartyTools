package com.example.partytools

import android.animation.ObjectAnimator
import android.animation.AnimatorSet
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import com.google.firebase.auth.FirebaseAuth

class Fiestas : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Para habilitar la visualización sin barra de estado
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

        // Animación de desvanecimiento (fade in) para el saludo
        val fadeIn = ObjectAnimator.ofFloat(welcomeTextView, "alpha", 0f, 1f)
        fadeIn.duration = 1000 // Duración de la animación (1 segundo)
        fadeIn.start()

        // Botones
        val buttonFiestasCerca = findViewById<Button>(R.id.button_fiestasCerca)
        val buttonComReuniones = findViewById<Button>(R.id.button_ComReuniones)

        // Texto debajo de los botones
        val textoFiestasCerca = findViewById<TextView>(R.id.text_fiestascerca)
        val textoComReuniones = findViewById<TextView>(R.id.text_comunidadreuniones)

        // Duración de las animaciones (más rápido)
        val animationDuration = 200L  // 0.2 segundos para mayor velocidad
        val delay = 100L             // 0.1 segundos de retraso entre cada animación

        // Crear animaciones de desplazamiento desde abajo para los botones con sus textos
        val translateButtonFiestasCerca = ObjectAnimator.ofFloat(buttonFiestasCerca, "translationY", 500f, 0f).apply {
            this.duration = animationDuration // Duración de la animación
            startDelay = 0 // No tiene retraso, comienza inmediatamente
        }
        val translateTextoFiestasCerca = ObjectAnimator.ofFloat(textoFiestasCerca, "translationY", 500f, 0f).apply {
            this.duration = animationDuration // Duración de la animación
            startDelay = 0 // Empieza al mismo tiempo que el botón
        }

        val translateButtonComReuniones = ObjectAnimator.ofFloat(buttonComReuniones, "translationY", 500f, 0f).apply {
            this.duration = animationDuration // Duración de la animación
            startDelay = delay // Se retrasa 0.1 segundos
        }
        val translateTextoComReuniones = ObjectAnimator.ofFloat(textoComReuniones, "translationY", 500f, 0f).apply {
            this.duration = animationDuration // Duración de la animación
            startDelay = delay // Se retrasa 0.1 segundos
        }

        // Agrupar todas las animaciones de los botones y textos en un AnimatorSet para que se inicien en secuencia
        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(
            fadeIn, // Primera animación: el saludo se hace visible
            translateButtonFiestasCerca,
            translateTextoFiestasCerca,
            translateButtonComReuniones,
            translateTextoComReuniones
        )

        // Iniciar las animaciones
        animatorSet.start()

        // Botón para navegar a F_Cerca
        buttonFiestasCerca.setOnClickListener {
            val intent = Intent(this, F_Cerca::class.java)
            startActivity(intent)
        }

        // Botón para navegar a F_Comunidad
        buttonComReuniones.setOnClickListener {
            val intent = Intent(this, F_Comunidad::class.java)
            startActivity(intent)
        }

        // Iconos y sus respectivas funciones (sin animaciones)
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

        // Botón para ir al perfil de usuario
        val btusuariofiestas = findViewById<ImageView>(R.id.usuario_fiestas)
        btusuariofiestas.setOnClickListener {
            val intent = Intent(this, Usuario::class.java)
            startActivity(intent)
        }
    }
}
