package com.example.irene_lopez_aguado_tarea_pmdm02.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.irene_lopez_aguado_tarea_pmdm02.R
import com.example.irene_lopez_aguado_tarea_pmdm02.fragments.FragmentMisActividades
import com.example.irene_lopez_aguado_tarea_pmdm02.fragments.FragmentReservas
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ItemAdapter(private val items: ArrayList<Item>, private val modo: String) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    private var selected = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)

        selected = false
        val boton: FloatingActionButton = holder.itemView.findViewById(R.id.tv_fab_fav)

        boton.setOnClickListener(View.OnClickListener {
            val btn: FloatingActionButton = it as FloatingActionButton

            if (modo.equals("reservas")) {
                selected = true
                btn.setImageResource(R.drawable.ic_close_24)
                FragmentReservas().addItem(item)
            } else if (modo.equals("actividades")) {
                selected = true
                btn.setImageResource(R.drawable.ic_close_24)
                FragmentMisActividades().deleteItem(item)
            }
        })
    }

    override fun getItemCount(): Int = items.size

    fun filtrar(query: String) {
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val titulo = view.findViewById<TextView>(R.id.tv_titulo)
        private val descripcion = view.findViewById<TextView>(R.id.tv_description)

        fun bind(item: Item) {
            titulo.text = item.titulo
            descripcion.text = item.descripcion
        }


    }
}
