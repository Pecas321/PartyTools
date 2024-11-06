package com.example.partytools

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ComunidadAdapter(private val comunidadList: List<Comunidad>) : RecyclerView.Adapter<ComunidadAdapter.ComunidadViewHolder>() {

    class ComunidadViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tituloTextView: TextView = itemView.findViewById(R.id.itemTitulo)
        val participantesTextView: TextView = itemView.findViewById(R.id.itemNumeroParticipantes)
        val descripcionTextView: TextView = itemView.findViewById(R.id.itemDescripcion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComunidadViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_fiesta, parent, false)
        return ComunidadViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComunidadViewHolder, position: Int) {
        val comunidad = comunidadList[position]
        holder.tituloTextView.text = comunidad.titulo
        holder.participantesTextView.text = "Participantes: ${comunidad.numeroParticipantes}"
        holder.descripcionTextView.text = comunidad.descripcion
    }

    override fun getItemCount(): Int {
        return comunidadList.size
    }
}
