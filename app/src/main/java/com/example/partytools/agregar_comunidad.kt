package com.example.partytools

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class agregar_comunidad : AppCompatActivity() {

    private lateinit var databaseRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_comunidad)

        val tituloEditText = findViewById<EditText>(R.id.editTextTitulo)
        val descripcionEditText = findViewById<EditText>(R.id.editTextDescripcion)
        val agregarButton = findViewById<Button>(R.id.btAgregarComunidad)

        databaseRef = FirebaseDatabase.getInstance().getReference("comunidades")

        agregarButton.setOnClickListener {
            val titulo = tituloEditText.text.toString()
            val descripcion = descripcionEditText.text.toString()
            val comunidadId = databaseRef.push().key ?: return@setOnClickListener

            val comunidad = Comunidad(titulo, numeroParticipantes = 0, descripcion)
            databaseRef.child(comunidadId).setValue(comunidad)

            // Regresar a la actividad F_Comunidad
            val intent = Intent(this, F_Comunidad::class.java)
            startActivity(intent)
            finish()  // Termina la actividad actual
        }
    }
}
