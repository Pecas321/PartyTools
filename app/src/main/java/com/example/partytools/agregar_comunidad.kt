import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AgregarComunidadActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_comunidad)  // Asegúrate de que coincide con el nombre del layout

        val editTextPlan: EditText = findViewById(R.id.editTextText3)
        val editTextDescripcion: EditText = findViewById(R.id.editTextText4)
        val buttonAgregar: Button = findViewById(R.id.bt_agregar_comunidad)

        // Inicializa la referencia de Firebase
        database = FirebaseDatabase.getInstance().reference

        buttonAgregar.setOnClickListener {
            val plan = editTextPlan.text.toString().trim()
            val descripcion = editTextDescripcion.text.toString().trim()

            // Valida que los campos no estén vacíos
            if (plan.isNotEmpty() && descripcion.isNotEmpty()) {
                // Crea un mapa con los datos a guardar
                val comunidadData = mapOf(
                    "plan" to plan,
                    "descripcion" to descripcion
                )

                // Guarda los datos en la base de datos en la ruta "comunidades"
                database.child("comunidades").push().setValue(comunidadData)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Comunidad agregada exitosamente", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Error al agregar comunidad", Toast.LENGTH_SHORT).show()
                    }
            } else {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
