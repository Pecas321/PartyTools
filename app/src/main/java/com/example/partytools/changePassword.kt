package com.example.partytools

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class changePassword : AppCompatActivity() {
    private lateinit var editTextCurrentPassword: EditText
    private lateinit var editTextNewPassword: EditText
    private lateinit var editTextConfirmNewPassword: EditText
    private lateinit var buttonSavePassword: Button
    private lateinit var buttonCancelPassword: Button
    private lateinit var volverButton: ImageView
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        // Inicializar vistas
        editTextCurrentPassword = findViewById(R.id.editTextCurrentPassword)
        editTextNewPassword = findViewById(R.id.editTextNewPassword)
        editTextConfirmNewPassword = findViewById(R.id.editTextConfirmNewPassword)
        buttonSavePassword = findViewById(R.id.buttonSavePassword)
        buttonCancelPassword = findViewById(R.id.buttonCancelPassword)
        volverButton = findViewById(R.id.Volver_change_password)

        auth = FirebaseAuth.getInstance()

        val user = auth.currentUser // Obtener el usuario autenticado

        // Botón para volver
        volverButton.setOnClickListener {
            finish()
        }

        // Botón Guardar Contraseña
        buttonSavePassword.setOnClickListener {
            val currentPassword = editTextCurrentPassword.text.toString()
            val newPassword = editTextNewPassword.text.toString()
            val confirmNewPassword = editTextConfirmNewPassword.text.toString()

            if (user != null) {
                // Verificar si las nuevas contraseñas coinciden
                if (newPassword == confirmNewPassword) {
                    // Crear las credenciales para la re-autenticación
                    val credential = EmailAuthProvider.getCredential(user.email!!, currentPassword)

                    // Re-autenticar al usuario con su contraseña actual
                    user.reauthenticate(credential)
                        .addOnCompleteListener { reAuthTask ->
                            if (reAuthTask.isSuccessful) {
                                // Contraseña autenticada correctamente, ahora actualizamos la nueva contraseña
                                user.updatePassword(newPassword)
                                    .addOnCompleteListener { task ->
                                        if (task.isSuccessful) {
                                            Toast.makeText(this, "Contraseña cambiada exitosamente", Toast.LENGTH_SHORT).show()
                                            finish() // Volver a la actividad anterior
                                        } else {
                                            Toast.makeText(this, "Error al actualizar la contraseña", Toast.LENGTH_SHORT).show()
                                        }
                                    }
                            } else {
                                Toast.makeText(this, "La contraseña actual es incorrecta", Toast.LENGTH_SHORT).show()
                            }
                        }
                } else {
                    Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Botón Cancelar
        buttonCancelPassword.setOnClickListener {
            finish()
        }
    }
}
