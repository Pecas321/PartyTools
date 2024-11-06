import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.partytools.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class agregar_comunidad : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_comunidad)

        val editTextPlan: EditText = findViewById(R.id.editTextText3)
        val editTextDescripcion: EditText = findViewById(R.id.editTextText4)
        val buttonAgregar: Button = findViewById(R.id.bt_agregar_comunidad)

        // Inicializa Firebase
        database = FirebaseDatabase.getInstance().reference

        buttonAgregar.setOnClickListener {
            val plan = editTextPlan.text.toString().trim()
            val descripcion = editTextDescripcion.text.toString().trim()

            if (plan.isNotEmpty() && descripcion.isNotEmpty()) {
                val comunidadData = mapOf(
                    "plan" to plan,
                    "descripcion" to descripcion
                )

                database.child("comunidades").push().setValue(comunidadData)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Comunidad agregada exitosamente", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener { exception ->
                        Log.e("FirebaseError", "Error al agregar comunidad", exception)
                        Toast.makeText(this, "Error al agregar comunidad: ${exception.message}", Toast.LENGTH_SHORT).show()
                    }
            } else {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
