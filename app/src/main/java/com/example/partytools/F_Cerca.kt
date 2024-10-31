package com.example.partytools

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class F_Cerca : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fiestas_cerca)

        // Configura el ImageView para volver a la actividad Fiestas
        val buttonVolver = findViewById<ImageView>(R.id.Volver_fiestascerca)
        buttonVolver.setOnClickListener {
            val intent = Intent(this, Fiestas::class.java)
            startActivity(intent)
        }

        // Configura el botón para navegar a activity_chapinero
        val buttonChapinero = findViewById<Button>(R.id.button_chapinero)
        buttonChapinero.setOnClickListener {
            val intent = Intent(this, Chapinero::class.java)
            startActivity(intent)
        }
    }
}
