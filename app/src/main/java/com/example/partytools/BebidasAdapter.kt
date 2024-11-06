package com.example.partytools

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.partytools.databinding.ItemBebidaBinding

class BebidasAdapter(private val listaBebidas: List<Bebida>) : RecyclerView.Adapter<BebidasAdapter.BebidaViewHolder>() {

    inner class BebidaViewHolder(private val binding: ItemBebidaBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(bebida: Bebida) {
            binding.imagenBebida.setImageResource(bebida.imagenResId)
            binding.nombreBebida.text = bebida.nombre
            binding.porcentajeAlcohol.text = "Alcohol: ${bebida.porcentajeAlcohol}"
            binding.precioBebida.text = "Precio: ${bebida.precio}"
            binding.saborBebida.text = "Sabor: ${bebida.sabor}"
            binding.coctelesRecomendados.text = "Cócteles: ${bebida.coctelesRecomendados}"

            // Configuramos el clic en la imagen
            binding.imagenBebida.setOnClickListener {
                // Abrimos el navegador con la URL de la bebida
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(bebida.url))
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BebidaViewHolder {
        val binding = ItemBebidaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BebidaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BebidaViewHolder, position: Int) {
        holder.bind(listaBebidas[position])
    }

    override fun getItemCount(): Int = listaBebidas.size
}
