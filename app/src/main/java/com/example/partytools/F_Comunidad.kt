package com.example.partytools

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class F_Comunidad : AppCompatActivity() {

    private lateinit var comunidadRecyclerView: RecyclerView
    private lateinit var comunidadList: ArrayList<Comunidad>
    private lateinit var comunidadAdapter: ComunidadAdapter
    private lateinit var databaseRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fcomunidad)

        // Configura el RecyclerView
        comunidadRecyclerView = findViewById(R.id.recycler_comunidad)
        comunidadRecyclerView.layoutManager = LinearLayoutManager(this)
        comunidadList = ArrayList()
        comunidadAdapter = ComunidadAdapter(comunidadList)
        comunidadRecyclerView.adapter = comunidadAdapter

        // Configura Firebase
        databaseRef = FirebaseDatabase.getInstance().getReference("comunidades")
        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                comunidadList.clear()
                for (dataSnapshot in snapshot.children) {
                    val comunidad = dataSnapshot.getValue(Comunidad::class.java)
                    comunidad?.let { comunidadList.add(it) }
                }
                comunidadAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                // Manejar errores de la base de datos
            }
        })

        // Botón para volver a la actividad Fiestas
        val buttonVolver = findViewById<ImageView>(R.id.Volver_fcomunidad)
        buttonVolver.setOnClickListener {
            val intent = Intent(this, Fiestas::class.java)
            startActivity(intent)
        }

        // Botón para ir a AgregarComunidad
        val buttonAgregarcomunidad = findViewById<ImageView>(R.id.agregar_comunidad_reunion)
        buttonAgregarcomunidad.setOnClickListener {
            val intent = Intent(this, agregar_comunidad::class.java)
            startActivity(intent)
        }
        
    }
}
