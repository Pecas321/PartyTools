package com.example.partytools

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class F_Comunidad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fcomunidad)

        // Configura el ImageView para volver a la actividad Fiestas
        val buttonVolver = findViewById<ImageView>(R.id.Volver_fcomunidad)
        buttonVolver.setOnClickListener {
            val intent = Intent(this, Fiestas::class.java)
            startActivity(intent)
        }
    }
}
