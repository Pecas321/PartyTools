package com.example.partytools

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView

class A_Calculadora : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_acalculadora)

        val volverButton = findViewById<ImageView>(R.id.Volver_acalculadora)
        volverButton.setOnClickListener {
            val intent = Intent(this, Alcoholseguro::class.java)
            startActivity(intent)
        }
    }
}
