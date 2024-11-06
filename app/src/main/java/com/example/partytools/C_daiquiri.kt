package com.example.partytools

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class C_daiquiri : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cdaiquiri)

        val buttonVolver = findViewById<ImageView>(R.id.Volver_daiquiri)
        buttonVolver.setOnClickListener {
            val intent = Intent(this, C_Recetas::class.java)
            startActivity(intent)
        }

    }
}