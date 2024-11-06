package com.example.partytools

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

private lateinit var etPeso: EditText
private lateinit var etCantidad: EditText
private lateinit var etGraduacion: EditText
private lateinit var btnCalcular: Button
private lateinit var tvResultado: TextView
private lateinit var btnVolver: ImageView

class A_Calculadora : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_acalculadora)

        etPeso = findViewById(R.id.etPeso)
        etCantidad = findViewById(R.id.etCantidad)
        etGraduacion = findViewById(R.id.etGraduacion)
        btnCalcular = findViewById(R.id.btnCalcular)
        tvResultado = findViewById(R.id.tvResultado)
        btnVolver = findViewById(R.id.Volver_calculadora)

        btnCalcular.setOnClickListener {
            calcularAlcohol()
        }

        btnVolver.setOnClickListener {
            val intent = Intent(this, Alcohol::class.java)
            startActivity(intent)
            finish() // Opcional: Finaliza esta actividad si no quieres regresar
        }
    }

    private fun calcularAlcohol() {
        val peso = etPeso.text.toString().toDoubleOrNull()
        val cantidad = etCantidad.text.toString().toDoubleOrNull()
        val graduacion = etGraduacion.text.toString().toDoubleOrNull()

        if (peso == null || cantidad == null || graduacion == null) {
            tvResultado.text = "Por favor, ingresa valores válidos."
            return
        }

        val volumenAlcohol = (cantidad * (graduacion / 100)) // en ml
        val gramosAlcohol = volumenAlcohol * 0.789 // 1 ml de alcohol pesa 0.789 g
        val bac = (gramosAlcohol / (peso * 1000)) * 100 // BAC en %

        // Formato del BAC y su significado
        val bacTexto = "Tu BAC es: %.2f%% (Concentración de Alcohol en la Sangre)".format(bac)

        // Mensaje de recomendación según el nivel de BAC
        val recomendacion = when {
            bac >= 0.08 -> "¡Nivel muy alto! Te recomendamos dejar de beber."
            bac >= 0.05 -> "Cuidado, tu nivel de alcohol está elevado. Considera hacer una pausa."
            bac >= 0.03 -> "Nivel moderado. Bebe con precaución."
            else -> "Nivel bajo de alcohol en sangre. Bebe responsablemente."
        }

        // Mostrar el BAC y la recomendación juntos
        tvResultado.text = "$bacTexto\n$recomendacion"
    }

}