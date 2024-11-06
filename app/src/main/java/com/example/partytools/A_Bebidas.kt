package com.example.partytools

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.partytools.databinding.ActivityAbebidasBinding

class A_Bebidas : AppCompatActivity() {

    private lateinit var binding: ActivityAbebidasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAbebidasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaBebidas = listOf(
            Bebida("Cerveza", R.drawable.cerveza, "4-6%", "$8,000", "Amargo", "Michelada, Radler"),
            Bebida("Vino", R.drawable.vino, "12-14%", "$40,000", "Frutal", "Sangría, Mimosa"),
            Bebida("Whisky", R.drawable.whisky, "40%", "$150,000", "Amaderado", "Old Fashioned, Whisky Sour"),
            Bebida("Ron", R.drawable.ron, "37-40%", "$90,000", "Dulce", "Mojito, Daiquiri"),
            Bebida("Vodka", R.drawable.vodka, "40%", "$100,000", "Neutral", "Bloody Mary, Cosmopolitan"),
            Bebida("Ginebra", R.drawable.ginebra, "37-47%", "$85,000", "Botánico", "Gin Tonic, Martini"),
            Bebida("Brandy", R.drawable.brandy, "35-60%", "$110,000", "Dulce", "Sidecar, Brandy Alexander"),
            Bebida("Tequila", R.drawable.tequila, "40%", "$70,000", "Fuerte", "Margarita, Tequila Sunrise"),
            Bebida("Baileys", R.drawable.baileys, "17%", "$65,000", "Cremoso", "Irish Coffee, Mudslide")
        )

        val bebidasAdapter = BebidasAdapter(listaBebidas)
        binding.recyclerViewBebidas.apply {
            layoutManager = LinearLayoutManager(this@A_Bebidas)
            adapter = bebidasAdapter
        }

        binding.VolverAbebidas.setOnClickListener {
            val intent = Intent(this, Alcohol::class.java)
            startActivity(intent)
            finish()
        }
    }
}
