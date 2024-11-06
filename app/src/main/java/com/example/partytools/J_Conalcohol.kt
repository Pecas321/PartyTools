package com.example.partytools

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class J_Conalcohol : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_jconalcohol)

        val volverButton = findViewById<ImageView>(R.id.Volver_jconalcohol)
        volverButton.setOnClickListener {
            finish()
        }

        // Configura el RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewJuegosAlcohol)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val juegosAlcohol = listOf(
            Juego("Ruleta", R.drawable.ruleta, "2-10", "18+", "Un juego de azar para beber con una ruleta.", "https://youtu.be/30HrLdUkhTU?si=27rcninOIsofwTi_", "https://www.exito.com/juego-ruleta-casino-drinking-shots-16-copas-102399296-mp/p"),
            Juego("Beer Pong", R.drawable.beer_pong, "2-4", "18+", "Lanza pelotas de ping pong en vasos de cerveza.", "https://youtu.be/BBfaEVKS6V8?si=c-tac5Nw3WRsq4vB", "https://articulo.mercadolibre.com.co/MCO-812369058-juego-mesa-fiesta-amigos-grupo-parche-beer-pong-bebidas-_JM?matt_tool=11175955&matt_word=&matt_source=google&matt_campaign_id=14635131292&matt_ad_group_id=139402079894&matt_match_type=&matt_network=g&matt_device=m&matt_creative=619486007230&matt_keyword=&matt_ad_position=&matt_ad_type=pla&matt_merchant_id=210266531&matt_product_id=MCO812369058&matt_product_partition_id=1816325304681&matt_target_id=pla-1816325304681&cq_src=google_ads&cq_cmp=14635131292&cq_net=g&cq_plt=gp&cq_med=pla&gad_source=1&gbraid=0AAAAAD1DcoyWtiBYgwAIdCixVvWqYEOOQ&gclid=Cj0KCQiAoae5BhCNARIsADVLzZdM74L2olf7JOfGReCEkAjBVrtfr_GiVmmLm_dDyTVc6K2mA0bLU5UaAoxbEALw_wcB&skipInApp=true"),
            Juego("Flip Cup", R.drawable.flip_cup, "2-8", "18+", "Toma y voltea el vaso de un solo intento.", "https://youtu.be/Mhnpzx3pbEk?si=irC7Mht8XChYy89Z", "https://www.amazon.com/-/es/Republic-Flip-Cup-Juego-beber/dp/B07W8Y5M92"),
            Juego("Dados Locos", R.drawable.dados_locos, "2-6", "18+", "Juego de azar con dados y retos al azar.", "https://youtu.be/wbBU92LlSFA?si=YdESqbAWcKEEkJHN", "https://www.curiocity.com.co/index.php?route=product/product&product_id=2058")
        )

        recyclerView.adapter = JuegoAdapter(this, juegosAlcohol)
    }
}
