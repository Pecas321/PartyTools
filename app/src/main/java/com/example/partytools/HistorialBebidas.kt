package com.example.partytools

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class HistorialBebidas : AppCompatActivity() {

    private lateinit var recyclerViewHistorial: RecyclerView
    private lateinit var historialBebidasAdapter: HistorialBebidasAdapter
    private val registrosList = mutableListOf<RegistroBebida>()
    private lateinit var database: DatabaseReference
    private val currentUserId: String? by lazy { FirebaseAuth.getInstance().currentUser?.uid }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial_bebidas)

        setupUI()
        currentUserId?.let {
            database = FirebaseDatabase.getInstance().getReference("HistorialBebidas")
            cargarHistorial()
        } ?: Log.e("HistorialBebidas", "Error: el ID de usuario es nulo.")
    }

    private fun setupUI() {
        recyclerViewHistorial = findViewById<RecyclerView>(R.id.recyclerViewHistorial).apply {
            layoutManager = LinearLayoutManager(this@HistorialBebidas)
            historialBebidasAdapter = HistorialBebidasAdapter(registrosList)
            adapter = historialBebidasAdapter
        }

        findViewById<ImageView>(R.id.Volver_historial_bebidas).setOnClickListener { finish() }
    }

    private fun cargarHistorial() {
        database.orderByChild("userId").equalTo(currentUserId).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                registrosList.clear()
                snapshot.children.mapNotNullTo(registrosList) { it.getValue(RegistroBebida::class.java) }
                historialBebidasAdapter.notifyDataSetChanged()
                Log.d("HistorialBebidas", "Historial cargado con éxito.")
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("HistorialBebidas", "Error al cargar el historial: ${error.message}")
            }
        })
    }
}
