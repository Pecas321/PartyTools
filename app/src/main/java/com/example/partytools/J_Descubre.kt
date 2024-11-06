package com.example.partytools

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.partytools.databinding.ActivityJdescubreBinding
import com.google.firebase.database.*
import androidx.recyclerview.widget.RecyclerView

class J_Descubre : AppCompatActivity() {

    private lateinit var binding: ActivityJdescubreBinding
    private lateinit var database: DatabaseReference
    private lateinit var juegosAdapterDescubre: JuegosAdapterDescubre
    private val juegosList = mutableListOf<JuegoDescubre>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJdescubreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = FirebaseDatabase.getInstance().getReference("juegos")

        juegosAdapterDescubre = JuegosAdapterDescubre(juegosList)
        binding.recyclerViewJuegosDescubre.apply {
            layoutManager = LinearLayoutManager(this@J_Descubre)
            adapter = juegosAdapterDescubre
        }

        binding.agregarJuego.setOnClickListener {
            val intent = Intent(this, AgregarJuegoActivity::class.java)
            startActivity(intent)
        }

        // Agregar el OnClickListener para el ImageView "Volver_jdescubre"
        val volverButton = findViewById<ImageView>(R.id.Volver_jdescubre)
        volverButton.setOnClickListener {
            // Crear un intent para navegar hacia la actividad Juegos.kt
            val intent = Intent(this, Juegos::class.java)
            startActivity(intent)
            finish()  // Esto cerrará la actividad actual (J_Descubre)
        }

        // Escuchar cambios en la base de datos
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                juegosList.clear()
                for (juegoSnapshot in snapshot.children) {
                    val juego = juegoSnapshot.getValue(JuegoDescubre::class.java)
                    juego?.let { juegosList.add(it) }
                }
                juegosAdapterDescubre.updateData(juegosList)
            }

            override fun onCancelled(error: DatabaseError) {
                // Manejo de errores
            }
        })
    }
}
