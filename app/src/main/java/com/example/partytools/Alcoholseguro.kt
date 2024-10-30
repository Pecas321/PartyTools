package com.example.partytools

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class Alcoholseguro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alcoholseguro)

        val buttonCalculadora = findViewById<Button>(R.id.button_calculadora)
        buttonCalculadora.setOnClickListener {
            val intent = Intent(this, A_Calculadora::class.java)
            startActivity(intent)
        }
    }
}
