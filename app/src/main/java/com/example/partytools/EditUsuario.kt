package com.example.partytools

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest // IMPORTAR ESTO
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class EditUsuario : AppCompatActivity() {

    private lateinit var databaseReference: DatabaseReference
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_usuario)

        auth = FirebaseAuth.getInstance()
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")

        val editTextUserName = findViewById<EditText>(R.id.editTextUserName)
        val buttonSaveUserName = findViewById<Button>(R.id.buttonSaveUserName)
        val buttonCancel = findViewById<Button>(R.id.buttonCancel)

        // Obtener el nombre actual del usuario desde Firebase
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val userId = currentUser.uid
            databaseReference.child(userId).child("name").get().addOnSuccessListener {
                val currentUserName = it.value as? String
                editTextUserName.setText(currentUserName)
            }.addOnFailureListener {
                Toast.makeText(this, "Error al obtener el nombre de usuario", Toast.LENGTH_SHORT).show()
            }
        }

        // Guardar el nuevo nombre en Firebase Realtime Database y actualizar el perfil en Firebase Auth
        buttonSaveUserName.setOnClickListener {
            val newUserName = editTextUserName.text.toString().trim()
            if (newUserName.isNotEmpty()) {
                currentUser?.let { user ->
                    val userId = user.uid
                    // Actualizar en Realtime Database
                    databaseReference.child(userId).child("name").setValue(newUserName)
                        .addOnSuccessListener {
                            // Actualizar en Firebase Auth
                            val profileUpdates = UserProfileChangeRequest.Builder()
                                .setDisplayName(newUserName) // Actualiza el displayName aquí
                                .build()

                            user.updateProfile(profileUpdates).addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    Toast.makeText(this, "Nombre de usuario actualizado", Toast.LENGTH_SHORT).show()
                                    finish() // Volver a la pantalla anterior
                                } else {
                                    Toast.makeText(this, "Error al actualizar el perfil", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                        .addOnFailureListener {
                            Toast.makeText(this, "Error al actualizar el nombre en la base de datos", Toast.LENGTH_SHORT).show()
                        }
                }
            } else {
                Toast.makeText(this, "Ingrese un nombre válido", Toast.LENGTH_SHORT).show()
            }
        }

        // Cancelar y volver a la pantalla anterior
        buttonCancel.setOnClickListener {
            finish()
        }
    }
}
