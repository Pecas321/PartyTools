package com.example.partytools

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HistorialBebidasAdapter(
    private val registros: List<RegistroBebida>
) : RecyclerView.Adapter<HistorialBebidasAdapter.HistorialViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistorialViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_historial_bebidas, parent, false)
        return HistorialViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistorialViewHolder, position: Int) {
        holder.bind(registros[position])
    }

    override fun getItemCount(): Int = registros.size

    inner class HistorialViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTipoBebida: TextView = itemView.findViewById(R.id.tvTipoBebida)
        private val tvFecha: TextView = itemView.findViewById(R.id.tvFecha)
        private val tvPeso: TextView = itemView.findViewById(R.id.tvPeso)
        private val tvCantidad: TextView = itemView.findViewById(R.id.tvCantidad)
        private val tvGraduacion: TextView = itemView.findViewById(R.id.tvGraduacion)
        private val tvBAC: TextView = itemView.findViewById(R.id.tvBAC)
        private val tvRecomendacion: TextView = itemView.findViewById(R.id.tvRecomendacion)

        fun bind(registro: RegistroBebida) {
            tvTipoBebida.text = "Tipo de bebida: ${registro.tipoBebida ?: "Desconocido"}"
            tvFecha.text = "Fecha: ${registro.fecha ?: "Desconocida"}"
            tvPeso.text = "Peso: ${registro.peso ?: 0} kg"
            tvCantidad.text = "Cantidad: ${registro.cantidad ?: 0} ml"
            tvGraduacion.text = "Graduación: ${registro.graduacion ?: 0.0}%"
            tvBAC.text = "BAC: %.2f%%".format(registro.bac ?: 0.0)
            tvRecomendacion.text = registro.recomendacion ?: "Sin recomendación"
        }
    }
}
