package com.example.partytools

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Juego(
    val nombre: String,
    val imagenResId: Int,
    val jugadores: String,
    val edad: String,
    val descripcion: String,
    val comoJugarUrl: String,
    val comprarUrl: String
)

class JuegoAdapter(private val context: Context, private val juegos: List<Juego>) :
    RecyclerView.Adapter<JuegoAdapter.JuegoViewHolder>() {

    inner class JuegoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imagen: ImageView = view.findViewById(R.id.juegoImagen)
        val nombre: TextView = view.findViewById(R.id.juegoNombre)
        val jugadores: TextView = view.findViewById(R.id.juegoJugadores)
        val edad: TextView = view.findViewById(R.id.juegoEdad)
        val descripcion: TextView = view.findViewById(R.id.juegoDescripcion)
        val comoJugar: TextView = view.findViewById(R.id.juegoComoJugar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JuegoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_juego, parent, false)
        return JuegoViewHolder(view)
    }

    override fun onBindViewHolder(holder: JuegoViewHolder, position: Int) {
        val juego = juegos[position]
        holder.nombre.text = juego.nombre
        holder.jugadores.text = "Jugadores: ${juego.jugadores}"
        holder.edad.text = "Edad: ${juego.edad}"
        holder.descripcion.text = juego.descripcion
        holder.imagen.setImageResource(juego.imagenResId)

        // Redirige a la página de compra al hacer clic en la imagen
        holder.imagen.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(juego.comprarUrl))
            context.startActivity(intent)
        }

        // Redirige a la guía de "¿Cómo jugar?" al hacer clic en el texto
        holder.comoJugar.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(juego.comoJugarUrl))
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = juegos.size
}
