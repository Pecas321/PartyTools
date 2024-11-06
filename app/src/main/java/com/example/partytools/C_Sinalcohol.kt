package com.example.partytools

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class C_Sinalcohol : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coctelessinalcochol)

        // Configura el ImageView para volver a la actividad Cocteles
        val buttonVolver = findViewById<ImageView>(R.id.Volver_coctelessinalcohol)
        buttonVolver.setOnClickListener {
            val intent = Intent(this, Cocteles::class.java)
            startActivity(intent)
        }
        val ButtonSanFrancisco = findViewById<Button>(R.id.ButtonSanFrancisco)
        ButtonSanFrancisco.setOnClickListener {
            val intent = Intent(this, CS_SanFrancisco::class.java) // Reemplaza C_Bellini con el nombre de tu actividad de destino
            startActivity(intent)
        }
        val ButtonLimFambruesas = findViewById<Button>(R.id.ButtonLimFambruesas)
        ButtonLimFambruesas.setOnClickListener {
            val intent = Intent(this, CS_limframbuesas::class.java) // Reemplaza C_Bellini con el nombre de tu actividad de destino
            startActivity(intent)
        }
    }
}
