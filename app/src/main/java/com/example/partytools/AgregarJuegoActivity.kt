package com.example.partytools

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.partytools.databinding.ActivityAgregarJuegoBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AgregarJuegoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAgregarJuegoBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgregarJuegoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = FirebaseDatabase.getInstance().getReference("juegos")

        binding.buttonAgregarJuego.setOnClickListener {
            val nombre = binding.inputNombre.text.toString()
            val numeroJugadores = binding.inputJugadores.text.toString().toIntOrNull()
            val edad = binding.inputEdad.text.toString().toIntOrNull()
            val reglas = binding.inputReglas.text.toString()
            val descripcion = binding.inputDescripcion.text.toString()

            if (nombre.isNotEmpty() && numeroJugadores != null && edad != null && reglas.isNotEmpty() && descripcion.isNotEmpty()) {
                val juegoId = database.push().key ?: return@setOnClickListener
                val juego = JuegoDescubre(nombre, numeroJugadores, edad, reglas, descripcion)

                database.child(juegoId).setValue(juego).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Juego agregado exitosamente", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, J_Descubre::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Error al agregar el juego", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        // Volver a J_Descubre
        binding.VolverAgregarJuego.setOnClickListener {
            val intent = Intent(this, J_Descubre::class.java)
            startActivity(intent)
        }
    }
}
