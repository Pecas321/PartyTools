package com.example.partytools

import android.animation.ObjectAnimator
import android.animation.AnimatorSet
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
        val nombreUsuario = user?.displayName ?: "Usuario" // Si no hay usuario, usar "Usuario" por defecto

        // Mostrar el nombre del usuario en el TextView correspondiente
        val textViewSaludo = findViewById<TextView>(R.id.Juegodemesa)
        textViewSaludo.text = "¡Hola $nombreUsuario! ¡Descubre deliciosos cocteles!"

        // Animación de desvanecimiento (fade in) para el saludo
        val fadeIn = ObjectAnimator.ofFloat(textViewSaludo, "alpha", 0f, 1f)
        fadeIn.duration = 1000 // Duración de la animación (1 segundo)
        fadeIn.start()

        // Botones
        val buttonJuegosMesa = findViewById<Button>(R.id.button_Recetas)
        val buttonJuegosAlcohol = findViewById<Button>(R.id.button_sinalcohol)

        // Texto debajo de los botones
        val textoJuegosMesa = findViewById<TextView>(R.id.texto_juegosmesa)
        val textoJuegosAlcohol = findViewById<TextView>(R.id.texto_juegosalcohol)

        // Duración de las animaciones (más rápido)
        val animationDuration = 200L  // 0.2 segundos para mayor velocidad
        val delay = 100L             // 0.1 segundos de retraso entre cada animación

        // Crear animaciones de desplazamiento desde abajo para los botones con sus textos
        val translateButtonJuegosMesa = ObjectAnimator.ofFloat(buttonJuegosMesa, "translationY", 500f, 0f).apply {
            this.duration = animationDuration // Duración de la animación
            startDelay = 0 // No tiene retraso, comienza inmediatamente
        }
        val translateTextoJuegosMesa = ObjectAnimator.ofFloat(textoJuegosMesa, "translationY", 500f, 0f).apply {
            this.duration = animationDuration // Duración de la animación
            startDelay = 0 // Empieza al mismo tiempo que el botón
        }

        val translateButtonJuegosAlcohol = ObjectAnimator.ofFloat(buttonJuegosAlcohol, "translationY", 500f, 0f).apply {
            this.duration = animationDuration // Duración de la animación
            startDelay = delay // Se retrasa 0.1 segundos
        }
        val translateTextoJuegosAlcohol = ObjectAnimator.ofFloat(textoJuegosAlcohol, "translationY", 500f, 0f).apply {
            this.duration = animationDuration // Duración de la animación
            startDelay = delay // Se retrasa 0.1 segundos
        }

        // Agrupar todas las animaciones de los botones y textos en un AnimatorSet para que se inicien en secuencia
        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(
            fadeIn, // Primera animación: el saludo se hace visible
            translateButtonJuegosMesa,
            translateTextoJuegosMesa,
            translateButtonJuegosAlcohol,
            translateTextoJuegosAlcohol
        )

        // Iniciar las animaciones
        animatorSet.start()

        // Botón a C_Recetas
        buttonJuegosMesa.setOnClickListener {
            val intent = Intent(this, C_Recetas::class.java)
            startActivity(intent)
        }

        // Botón a C_Sinalcohol
        buttonJuegosAlcohol.setOnClickListener {
            val intent = Intent(this, C_Sinalcohol::class.java)
            startActivity(intent)
        }

        // Iconos y sus respectivas funciones (sin animaciones)
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

        // Botón para ir al perfil de usuario
        val btusuariococteles = findViewById<ImageView>(R.id.usuario_cocteles)
        btusuariococteles.setOnClickListener {
            val intent = Intent(this, Usuario::class.java)
            startActivity(intent)
        }
    }
}
