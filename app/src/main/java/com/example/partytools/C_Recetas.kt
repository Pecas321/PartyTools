package com.example.partytools

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class C_Recetas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recetacocteles)

        // Configura el ImageView para volver a la actividad Cocteles
        val buttonVolver = findViewById<ImageView>(R.id.Volver_recetascocteles)
        buttonVolver.setOnClickListener {
            val intent = Intent(this, Cocteles::class.java)
            startActivity(intent)
        }
        val buttonBellini = findViewById<Button>(R.id.ButtonBellini)
        buttonBellini.setOnClickListener {
            val intent = Intent(this, C_Bellini::class.java) // Reemplaza C_Bellini con el nombre de tu actividad de destino
            startActivity(intent)
        }
        val buttonTequilaSunrise = findViewById<Button>(R.id.ButtonTequilaSunrise)
        buttonTequilaSunrise.setOnClickListener {
            val intent = Intent(this, C_tequilaSonrise::class.java) // Reemplaza C_Bellini con el nombre de tu actividad de destino
            startActivity(intent)
        }
        val ButtonDaiquiri = findViewById<Button>(R.id.ButtonDaiquiri)
        ButtonDaiquiri.setOnClickListener {
            val intent = Intent(this, C_daiquiri::class.java) // Reemplaza C_Bellini con el nombre de tu actividad de destino
            startActivity(intent)
        }
    }
}
