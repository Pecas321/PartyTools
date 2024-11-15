package com.example.partytools

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CocktailDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cocktail_detail)

        val cocktailName = intent.getStringExtra("COCKTAIL_NAME") ?: "Cóctel"
        val cocktailIngredients = intent.getStringExtra("COCKTAIL_INGREDIENTS") ?: "Ingredientes no disponibles"
        val cocktailPreparation = intent.getStringExtra("COCKTAIL_PREPARATION") ?: "Preparación no disponible"
        val cocktailImageResId = intent.getIntExtra("COCKTAIL_IMAGE", R.drawable.bellini)

        findViewById<TextView>(R.id.cocktailNameTextView).text = cocktailName
        findViewById<TextView>(R.id.cocktailIngredientsTextView).text = cocktailIngredients
        findViewById<TextView>(R.id.cocktailPreparationTextView).text = cocktailPreparation
        findViewById<ImageView>(R.id.cocktailImageView).setImageResource(cocktailImageResId)

        findViewById<ImageView>(R.id.backButton).setOnClickListener {
            finish() // Regresa a la actividad anterior
        }
    }
}
