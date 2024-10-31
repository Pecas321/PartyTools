package com.example.partytools

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class Registrarse : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)

        auth = FirebaseAuth.getInstance()

        val emailEditText = findViewById<EditText>(R.id.editTextTextEmailAddress2)
        val passwordEditText = findViewById<EditText>(R.id.editTextTextPassword2)
        val registrarseButton = findViewById<Button>(R.id.registrarse_registrarse)

        // Botón para registrar un nuevo usuario
        registrarseButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, Main::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "Error en el registro: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
