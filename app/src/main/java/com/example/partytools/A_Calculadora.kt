package com.example.partytools

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.auth.FirebaseAuth
import java.text.SimpleDateFormat
import java.util.*
import android.app.DatePickerDialog

class A_Calculadora : AppCompatActivity() {

    private lateinit var etPeso: EditText
    private lateinit var etCantidad: EditText
    private lateinit var etGraduacion: EditText
    private lateinit var btnCalcular: Button
    private lateinit var tvResultado: TextView
    private lateinit var btnVolver: ImageView
    private lateinit var spinnerBebida: Spinner
    private lateinit var etFecha: EditText
    private lateinit var database: DatabaseReference
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acalculadora)

        etPeso = findViewById(R.id.etPeso)
        etCantidad = findViewById(R.id.etCantidad)
        etGraduacion = findViewById(R.id.etGraduacion)
        btnCalcular = findViewById(R.id.btnCalcular)
        tvResultado = findViewById(R.id.tvResultado)
        btnVolver = findViewById(R.id.Volver_calculadora)
        spinnerBebida = findViewById(R.id.spinnerBebida)
        etFecha = findViewById(R.id.etFecha)

        // Configuración de Firebase
        database = FirebaseDatabase.getInstance().getReference("HistorialBebidas")
        auth = FirebaseAuth.getInstance()

        // Configuración del Spinner con las opciones de bebidas
        val bebidas = arrayOf(
            "Tipo de bebida", "Cerveza", "Vino", "Aguardiente", "Whisky", "Ron",
            "Vodka", "Ginebra", "Brandy", "Tequila", "Baileys"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, bebidas)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerBebida.adapter = adapter

        // Configuración del DatePicker para seleccionar la fecha
        etFecha.setOnClickListener { showDatePicker() }

        // Inicializar el campo de fecha con la fecha actual
        val currentDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
        etFecha.setText(currentDate)

        // Calcular el alcohol cuando el botón sea presionado
        btnCalcular.setOnClickListener { calcularAlcohol() }

        // Volver a la pantalla anterior
        btnVolver.setOnClickListener {
            val intent = Intent(this, Alcohol::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun calcularAlcohol() {
        val peso = etPeso.text.toString().toDoubleOrNull()
        val cantidad = etCantidad.text.toString().toDoubleOrNull()
        val graduacion = etGraduacion.text.toString().toDoubleOrNull()
        val tipoBebida = spinnerBebida.selectedItem.toString()
        val fecha = etFecha.text.toString()

        if (tipoBebida == "Tipo de bebida") {
            tvResultado.text = "Por favor, selecciona un tipo de bebida."
            return
        }

        if (peso == null || cantidad == null || graduacion == null) {
            tvResultado.text = "Por favor, ingresa valores válidos."
            return
        }

        val volumenAlcohol = (cantidad * (graduacion / 100))
        val gramosAlcohol = volumenAlcohol * 0.789
        val bac = (gramosAlcohol / (peso * 1000)) * 100

        val bacTexto = "Tu BAC es: %.2f%% (Concentración de Alcohol en la Sangre)".format(bac)

        val recomendacion = when {
            bac >= 0.08 -> "¡Nivel muy alto! Te recomendamos dejar de beber."
            bac >= 0.05 -> "Cuidado, tu nivel de alcohol está elevado. Considera hacer una pausa."
            bac >= 0.03 -> "Nivel moderado. Bebe con precaución."
            else -> "Nivel bajo de alcohol en sangre. Bebe responsablemente."
        }

        tvResultado.text = "$bacTexto\nTipo de bebida: $tipoBebida\n$recomendacion"

        // Obtener el userId del usuario autenticado
        val userId = auth.currentUser?.uid

        // Guardar el registro en Firebase con el userId
        if (userId != null) {
            val registroBebida = RegistroBebida(
                tipoBebida = tipoBebida,
                fecha = fecha,
                peso = peso,
                cantidad = cantidad,
                graduacion = graduacion,
                bac = bac,
                recomendacion = recomendacion,
                userId = userId
            )
            guardarRegistroEnFirebase(registroBebida)
        } else {
            tvResultado.append("\n\nError: usuario no autenticado.")
        }
    }

    private fun guardarRegistroEnFirebase(registro: RegistroBebida) {
        val registroId = database.push().key
        if (registroId != null) {
            database.child(registroId).setValue(registro)
                .addOnSuccessListener {
                    tvResultado.append("\n\nRegistro guardado en el historial.")
                }
                .addOnFailureListener {
                    tvResultado.append("\n\nError al guardar el registro.")
                }
        }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            etFecha.setText("$selectedDay/${selectedMonth + 1}/$selectedYear")
        }, year, month, day)

        datePickerDialog.show()
    }
}
