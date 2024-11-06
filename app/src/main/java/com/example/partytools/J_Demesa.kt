package com.example.partytools

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class J_Demesa : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_juegosdemesa)

        val volverButton = findViewById<ImageView>(R.id.Volver_juegosdemesa)
        volverButton.setOnClickListener {
            finish() // Vuelve a la actividad anterior
        }

        // Configura el RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewJuegos)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Lista de juegos con sus enlaces en formato de una sola línea
        val juegos = listOf(
            Juego("Uno", R.drawable.uno, "2-10", "7+", "Juego de cartas clásico y fácil de aprender.", "https://www.youtube.com/watch?v=DQzOvL87vss", "https://www.exito.com/uno"),
            Juego("Rummikub", R.drawable.rummikub, "2-4", "8+", "Juego de números y lógica para crear secuencias y combinaciones.", "https://youtu.be/tm6A2m_09Do?si=Q0dvvFNZxbcK36yd", "https://www.exito.com/juego-de-mesa-rummikub-classic-el-rummy-estrategia-102541842-mp/p"),
            Juego("Jenga", R.drawable.jenga, "2-4", "8+", "Juego de habilidad donde los jugadores sacan bloques de una torre sin derribarla.", "https://www.youtube.com/watch?v=L9qLJCZre5o", "https://www.exito.com/jenga-refresh-287522/p"),
            Juego("Monopoly", R.drawable.monopoly, "2-6", "8+", "Juego de bienes raíces donde los jugadores compran, venden y negocian propiedades.", "https://youtu.be/D1aeCe2ydXw?si=AkQP9PLsxlqCjWRs", "https://www.exito.com/juego-mesa-monopoly-nuevos-tok-867079/p"),
            Juego("Clue", R.drawable.clue, "3-6", "8+", "Juego de misterio donde los jugadores deben descubrir quién cometió el crimen, con qué arma y en qué habitación.", "https://youtu.be/rSRCqnYN_Fw?si=kJT94_giz3rJ-gEc", "https://www.exito.com/juego-de-mesa-clue-hasbro-gaming-3117192/p"),
            Juego("Parqués", R.drawable.parques, "2-4", "6+", "Juego de mesa de estrategia popular en Colombia.", "https://www.youtube.com/watch?v=fTiyZUXiSWA", "https://www.exito.com/parques-6-puestos-6001/p"),
            Juego("Hedbanz", R.drawable.hedbanz, "4-6", "8+", "Juego de adivinanza donde se usa una tarjeta en la frente.", "https://www.youtube.com/watch?v=n5vPm0m8cv4", "https://www.exito.com/hedbanz-clasico-boing-toys-3187970-3612792/p"),
            Juego("Domino", R.drawable.domino, "2-4", "6+", "Juego clásico de dominó con fichas numéricas.", "https://www.youtube.com/watch?v=r0bhtmXjDnU", "https://www.exito.com/juego-de-domino-clasico-con-28-piezas-y-caja-portable-101281102-mp/p"),
            Juego("Twister", R.drawable.twister, "2+", "6+", "Juego de habilidad física donde los jugadores colocan sus manos y pies en círculos de colores.", "https://www.youtube.com/watch?v=hA9l6KsLqWY", "https://www.exito.com/twister-refresh-137605/p"),
            Juego("Damas Chinas", R.drawable.damas_chinas, "2-6", "6+", "Juego de mesa clásico de estrategia para varios jugadores.", "https://youtu.be/gb_tCvRWz4s?si=5isS0KeKl0TCKRlF", "https://www.exito.com/damas-chinas-clasico-ronda-051201-704499/p"),
            Juego("Stop, papel y lápiz", R.drawable.stop, "2+", "6+", "Juego de velocidad y creatividad con palabras.", "https://youtu.be/Y1zU9RtQ3j0?si=80n6AxrOumc1-Dkt", "https://www.falabella.com.co/falabella-co/product/2004764/Stop/2004764"),
            Juego("Ahorcado", R.drawable.ahorcado, "2+", "6+", "Juego de adivinanza de palabras clásico.", "https://youtu.be/xv5PG-U6tXk?si=mMGxsv3sGu4EDuAr", "https://play.google.com/store/apps/details?id=com.tellmewow.senior.hangman&hl=es_CO") ,
            Juego("Batalla Naval", R.drawable.batalla_naval, "2", "6+", "Juego de estrategia naval donde los jugadores deben hundir los barcos del rival.", "https://www.youtube.com/watch?v=Q1cP-yugi5M&t=1s", "https://www.exito.com/hasbro-gaming-battleship-hasbro-gaming-f4527-3071072/p"),
            Juego("Ajedrez", R.drawable.ajedrez, "2", "6+", "Juego de estrategia y habilidad mental entre dos jugadores.", "https://youtu.be/G7iGNPzaQIY?si=IULLq-iYyVmoUU_F", "https://www.exito.com/ajedrez-clasico-704508/p"),
        )

        // Asignamos el adaptador al RecyclerView
        recyclerView.adapter = JuegoAdapter(this, juegos)
    }
}
