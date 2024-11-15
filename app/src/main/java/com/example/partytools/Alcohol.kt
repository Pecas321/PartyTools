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

class Alcohol : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alcohol)

        // Obtener el nombre del usuario autenticado
        val user = FirebaseAuth.getInstance().currentUser
        val username = user?.displayName

        // Mostrar el nombre en el TextView
        val textViewAlcohol = findViewById<TextView>(R.id.text_alcoholseguro)
        textViewAlcohol.text = "Bienvenido $username\n¡Bebe Responsablemente!"

        // Animación de desvanecimiento (fade in) para el saludo
        val fadeIn = ObjectAnimator.ofFloat(textViewAlcohol, "alpha", 0f, 1f)
        fadeIn.duration = 1000 // Duración de la animación (1 segundo)
        fadeIn.start()

        // Botones
        val buttonCalculadora = findViewById<Button>(R.id.button_calculadora)
        val buttonBebidas = findViewById<Button>(R.id.button_bebidas)
        val buttonEmergencias = findViewById<Button>(R.id.Button_emergencias)
        val bthistorialbebidas = findViewById<Button>(R.id.Button_historial_bebidas)

        // Texto debajo de los botones
        val textoCalculadora = findViewById<TextView>(R.id.text_calculadora)
        val textoBebidas = findViewById<TextView>(R.id.texto_buttonbebidas)
        val textoEmergencias = findViewById<TextView>(R.id.texto_emergencias)
        val textoHistorialBebidas = findViewById<TextView>(R.id.texto_historial_bebidas)

        // Duración de las animaciones (más rápido)
        val animationDuration = 200L  // 0.2 segundos para mayor velocidad
        val delay = 100L             // 0.1 segundos de retraso entre cada animación

        // Crear animaciones de desplazamiento desde abajo para los botones con sus textos
        val translateButtonCalculadora = ObjectAnimator.ofFloat(buttonCalculadora, "translationY", 500f, 0f).apply {
            this.duration = animationDuration // Duración de la animación
            startDelay = 0 // No tiene retraso, comienza inmediatamente
        }
        val translateTextoCalculadora = ObjectAnimator.ofFloat(textoCalculadora, "translationY", 500f, 0f).apply {
            this.duration = animationDuration // Duración de la animación
            startDelay = 0 // Empieza al mismo tiempo que el botón
        }

        val translateButtonBebidas = ObjectAnimator.ofFloat(buttonBebidas, "translationY", 500f, 0f).apply {
            this.duration = animationDuration // Duración de la animación
            startDelay = delay // Se retrasa 0.1 segundos
        }
        val translateTextoBebidas = ObjectAnimator.ofFloat(textoBebidas, "translationY", 500f, 0f).apply {
            this.duration = animationDuration // Duración de la animación
            startDelay = delay // Se retrasa 0.1 segundos
        }

        val translateButtonEmergencias = ObjectAnimator.ofFloat(buttonEmergencias, "translationY", 500f, 0f).apply {
            this.duration = animationDuration // Duración de la animación
            startDelay = delay * 2 // Se retrasa 0.2 segundos
        }
        val translateTextoEmergencias = ObjectAnimator.ofFloat(textoEmergencias, "translationY", 500f, 0f).apply {
            this.duration = animationDuration // Duración de la animación
            startDelay = delay * 2 // Se retrasa 0.2 segundos
        }

        val translateButtonHistorialBebidas = ObjectAnimator.ofFloat(bthistorialbebidas, "translationY", 500f, 0f).apply {
            this.duration = animationDuration // Duración de la animación
            startDelay = delay * 3 // Se retrasa 0.3 segundos
        }
        val translateTextoHistorialBebidas = ObjectAnimator.ofFloat(textoHistorialBebidas, "translationY", 500f, 0f).apply {
            this.duration = animationDuration // Duración de la animación
            startDelay = delay * 3 // Se retrasa 0.3 segundos
        }

        // Agrupar todas las animaciones de los botones y textos en un AnimatorSet para que se inicien en secuencia
        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(
            fadeIn, // Primera animación: el saludo se hace visible
            translateButtonCalculadora,
            translateTextoCalculadora,
            translateButtonBebidas,
            translateTextoBebidas,
            translateButtonEmergencias,
            translateTextoEmergencias,
            translateButtonHistorialBebidas,
            translateTextoHistorialBebidas
        )

        // Iniciar las animaciones
        animatorSet.start()

        // Botón a A_Calculadora
        buttonCalculadora.setOnClickListener {
            val intent = Intent(this, A_Calculadora::class.java)
            startActivity(intent)
        }

        // Botón a A_Bebidas
        buttonBebidas.setOnClickListener {
            val intent = Intent(this, A_Bebidas::class.java)
            startActivity(intent)
        }

        // Botón a A_Emergencia
        buttonEmergencias.setOnClickListener {
            val intent = Intent(this, A_Emergencia::class.java)
            startActivity(intent)
        }

        // Botón para ir a Juegos
        val iconoJuegosAlcohol = findViewById<ImageView>(R.id.icono_juegos_alcohol)
        iconoJuegosAlcohol.setOnClickListener {
            val intent = Intent(this, Juegos::class.java)
            startActivity(intent)
        }

        // Botón para ir a Fiestas
        val iconoFiestaAlcohol = findViewById<ImageView>(R.id.icono_fiesta_alcohol)
        iconoFiestaAlcohol.setOnClickListener {
            val intent = Intent(this, Fiestas::class.java)
            startActivity(intent)
        }

        // Botón para ir a Cocteles
        val iconoCoctelesAlcohol = findViewById<ImageView>(R.id.icono_cocteles_alcohol)
        iconoCoctelesAlcohol.setOnClickListener {
            val intent = Intent(this, Cocteles::class.java)
            startActivity(intent)
        }

        // Botón para ir al perfil de usuario
        val btusuarioalcohol = findViewById<ImageView>(R.id.usuario_alcohol)
        btusuarioalcohol.setOnClickListener {
            val intent = Intent(this, Usuario::class.java)
            startActivity(intent)
        }

        // Botón para ir al historial de bebidas
        val buttonhistorialbebidas = findViewById<Button>(R.id.Button_historial_bebidas)
        buttonhistorialbebidas.setOnClickListener {
            val intent = Intent(this, HistorialBebidas::class.java)
            startActivity(intent)
        }
    }
}
