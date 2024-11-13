package com.example.partytools

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class Usuario : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario)

        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser

        // Mostrar nombre y correo
        val textViewUsername = findViewById<TextView>(R.id.textViewUsername)
        val textViewEmail = findViewById<TextView>(R.id.textViewEmail)

        textViewUsername.text = "Nombre de usuario: ${currentUser?.displayName ?: "N/A"}"
        textViewEmail.text = "Correo: ${currentUser?.email ?: "N/A"}"

        // Configurar botones
        val buttonDeleteAccount = findViewById<Button>(R.id.buttonDeleteAccount)
        val buttonSignOut = findViewById<Button>(R.id.buttonSignOut)

        buttonDeleteAccount.setOnClickListener { deleteAccount() }
        buttonSignOut.setOnClickListener { signOut() }

        // Configuración del botón Volver
        val imageViewVolver = findViewById<ImageView>(R.id.Volver_usuario)
        imageViewVolver.setOnClickListener {
            finish()
        }

        val buttonEditUser = findViewById<Button>(R.id.buttonEditUser)
        buttonEditUser.setOnClickListener {
            val intent = Intent(this, EditUsuario::class.java)
            startActivity(intent)
        }

        val buttonChangePassword = findViewById<Button>(R.id.buttonChangePassword)
        buttonChangePassword.setOnClickListener {
            val intent = Intent(this, changePassword::class.java)
            startActivity(intent)
        }

    }


    private fun deleteAccount() {
        auth.currentUser?.delete()?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "Cuenta eliminada", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Main::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Error al eliminar la cuenta", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun signOut() {
        auth.signOut()
        val intent = Intent(this, Main::class.java)
        startActivity(intent)
        finish()
    }
}
