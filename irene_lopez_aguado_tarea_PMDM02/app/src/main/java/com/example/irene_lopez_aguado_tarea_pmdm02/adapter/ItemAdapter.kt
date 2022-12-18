package com.example.irene_lopez_aguado_tarea_pmdm02.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.irene_lopez_aguado_tarea_pmdm02.R


class ItemAdapter(private val items: ArrayList<Item>): RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.view_item, parent, false)

        return ViewHolder(view)
   }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    fun filtrar(query: String){
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val titulo_actividad = view.findViewById<TextView>(R.id.tv_actividad)
        private val descripcion_actividad = view.findViewById<TextView>(R.id.tv_description_actividad)
        private val btn_actividad = view.findViewById<TextView>(R.id.tv_fab_fav)

        fun bind(item: Item){
            titulo_actividad.text = item.titulo
            descripcion_actividad.text =item.descripcion
        }
    }

}