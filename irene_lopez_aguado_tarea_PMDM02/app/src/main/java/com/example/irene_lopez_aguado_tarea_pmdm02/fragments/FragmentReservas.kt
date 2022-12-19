package com.example.irene_lopez_aguado_tarea_pmdm02.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.irene_lopez_aguado_tarea_pmdm02.R
import com.example.irene_lopez_aguado_tarea_pmdm02.adapter.Item
import com.example.irene_lopez_aguado_tarea_pmdm02.adapter.ItemAdapter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentReservas.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentReservas : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    protected val lista: ArrayList<Item> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_reservas, container, false)

        /*RecyclerView*/
        val rv = view.findViewById(R.id.rv_lista_reservas) as RecyclerView


        //Obtenemos la referencia a la BBDD
        val db = Firebase.firestore

        //Obtenemos acceso a la colección
        val reservas = db.collection("reservas")

        //Obtenemos todos los documentos de una coleeción
        reservas
            .get()
            .addOnSuccessListener { result ->
                //Recorre el documento buscando los elementos que se le indican
                // todo este proceso es de manera asincrona
            for (document in result) {
                var item = Item(
                    document.get("titulo").toString(),
                    document.get("descripcion").toString(),
                    document.get("id").toString()
                )
                lista.add(item)
            }
                //Tras leer todos los documentos de la bbdd
            rv.adapter = ItemAdapter(lista, "reservas")
        }.addOnFailureListener { exception ->
                Toast.makeText(context, "Error al leer el fichero", Toast.LENGTH_SHORT).show()
            }
    return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentReservas.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) = FragmentReservas().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
    }

        fun addItem(item :Item){
        val db = Firebase.firestore
        //añadimos a la reservas pues la lista.
        db.collection("lista_seleccionados").document(item.id).set(item) //añadimos a la base de datos la lista
            .addOnFailureListener{ exception ->
                Toast.makeText(context,"error",Toast.LENGTH_LONG).show()
            }

    }
}