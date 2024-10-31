package com.example.partytools

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class Iniciosesion : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio_sesion)

        auth = FirebaseAuth.getInstance()

        val emailEditText = findViewById<EditText>(R.id.editTextTextEmailAddress2)
        val passwordEditText = findViewById<EditText>(R.id.editTextTextPassword2)
        val iniciarSesionButton = findViewById<Button>(R.id.iniciarsesion_inicio)

        // Configurar botón de "Volver"
        val volverButton = findViewById<Button>(R.id.registrarse_main)
        volverButton.setOnClickListener {
            val intent = Intent(this, Main::class.java)
            startActivity(intent)
            finish()
        }

        // Botón de iniciar sesión
        iniciarSesionButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(this, Inicio::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "Error en la autenticación: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
