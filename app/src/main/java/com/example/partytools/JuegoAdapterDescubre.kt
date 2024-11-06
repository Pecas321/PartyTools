package com.example.partytools

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JuegosAdapterDescubre(
    private var juegosList: List<JuegoDescubre>
) : RecyclerView.Adapter<JuegosAdapterDescubre.JuegoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JuegoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_juego_descubre, parent, false)
        return JuegoViewHolder(view)
    }

    override fun onBindViewHolder(holder: JuegoViewHolder, position: Int) {
        val juego = juegosList[position]
        holder.bind(juego)
    }

    override fun getItemCount(): Int = juegosList.size

    fun updateData(newJuegosList: List<JuegoDescubre>) {
        juegosList = newJuegosList
        notifyDataSetChanged()
    }

    inner class JuegoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvNombreJuego: TextView = itemView.findViewById(R.id.tvNombreJuego)
        private val tvNumeroJugadores: TextView = itemView.findViewById(R.id.tvNumeroJugadores)
        private val tvEdad: TextView = itemView.findViewById(R.id.tvEdad)
        private val tvReglas: TextView = itemView.findViewById(R.id.tvReglas)
        private val tvDescripcion: TextView = itemView.findViewById(R.id.tvDescripcion)

        fun bind(juego: JuegoDescubre) {
            tvNombreJuego.text = juego.nombre
            tvNumeroJugadores.text = "Número de jugadores: ${juego.numeroJugadores}"
            tvEdad.text = "Edad recomendada: ${juego.edad}"
            tvReglas.text = "Reglas: ${juego.reglas}"
            tvDescripcion.text = "Descripción: ${juego.descripcion}"
        }
    }
}
