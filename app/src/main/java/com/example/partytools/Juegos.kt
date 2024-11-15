package com.example.partytools

import android.content.Intent
import android.os.Bundle
import android.animation.ObjectAnimator
import android.animation.AnimatorSet
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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

        // Animación de Alpha (desaparecer a aparecer) para el saludo
        val alphaAnimation = ObjectAnimator.ofFloat(textViewSaludo, "alpha", 0f, 1f).apply {
            duration = 1000 // 1 segundo para que se haga visible
        }

        // Botones
        val buttonTquila = findViewById<Button>(R.id.button_Recetas)
        val buttonAlcohol = findViewById<Button>(R.id.button_sinalcohol)
        val buttonDescubre = findViewById<Button>(R.id.Descubre_juegos)

        // Texto debajo de los botones
        val textoJuegosMesa = findViewById<TextView>(R.id.texto_juegosmesa)
        val textoJuegosAlcohol = findViewById<TextView>(R.id.texto_juegosalcohol)
        val textoDescubreJuegos = findViewById<TextView>(R.id.texto_descubrejuegos)

        // Duración de las animaciones (más rápido)
        val animationDuration = 200L
        val delay = 100L

        // Crear animaciones de desplazamiento desde abajo para los elementos
        val translateButtonTquila = ObjectAnimator.ofFloat(buttonTquila, "translationY", 500f, 0f).apply {
            this.duration = animationDuration // Duración de la animación
            startDelay = 0 // No tiene retraso, comienza inmediatamente
        }
        val translateTextoJuegosMesa = ObjectAnimator.ofFloat(textoJuegosMesa, "translationY", 500f, 0f).apply {
            this.duration = animationDuration // Duración de la animación
            startDelay = 0 // Empieza al mismo tiempo que el botón
        }

        val translateButtonAlcohol = ObjectAnimator.ofFloat(buttonAlcohol, "translationY", 500f, 0f).apply {
            this.duration = animationDuration // Duración de la animación
            startDelay = delay // Se retrasa 0.2 segundos
        }
        val translateTextoJuegosAlcohol = ObjectAnimator.ofFloat(textoJuegosAlcohol, "translationY", 500f, 0f).apply {
            this.duration = animationDuration // Duración de la animación
            startDelay = delay // Se retrasa 0.2 segundos
        }

        val translateButtonDescubre = ObjectAnimator.ofFloat(buttonDescubre, "translationY", 500f, 0f).apply {
            this.duration = animationDuration // Duración de la animación
            startDelay = delay * 2 // Se retrasa 0.4 segundos
        }
        val translateTextoDescubreJuegos = ObjectAnimator.ofFloat(textoDescubreJuegos, "translationY", 500f, 0f).apply {
            this.duration = animationDuration // Duración de la animación
            startDelay = delay * 2 // Se retrasa 0.4 segundos
        }

        // Agrupar todas las animaciones en un AnimatorSet para que se inicien en secuencia
        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(
            alphaAnimation, // Primera animación: el saludo se hace visible
            translateButtonTquila,
            translateTextoJuegosMesa,
            translateButtonAlcohol,
            translateTextoJuegosAlcohol,
            translateButtonDescubre,
            translateTextoDescubreJuegos
        )

        // Iniciar las animaciones
        animatorSet.start()

        // Botón a J_Demesa
        buttonTquila.setOnClickListener {
            val intent = Intent(this, J_Demesa::class.java)
            startActivity(intent)
        }

        // Botón a J_Conalcohol
        buttonAlcohol.setOnClickListener {
            val intent = Intent(this, J_Conalcohol::class.java)
            startActivity(intent)
        }

        // Botón a J_Descubre
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

        // Botón para ir a Usuario
        val btusuariojuegos = findViewById<ImageView>(R.id.usuario_juegos)
        btusuariojuegos.setOnClickListener {
            val intent = Intent(this, Usuario::class.java)
            startActivity(intent)
        }
    }
}
