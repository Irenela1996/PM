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
 * Use the [FragmentMisActividades.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentMisActividades : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_mis_actividades, container, false)

        /*RecyclerView*/
        val rv = view.findViewById(R.id.rv_lista_mis_actividades) as RecyclerView

        var lista: ArrayList<Item> = ArrayList()

        //Obtenemos la referencia a la BBDD
        val db = Firebase.firestore

        //Obtenemos acceso a la colección
        val actividades = db.collection("lista_seleccionados")

        //Obtenemos todos los documentos de una colección
        actividades.get().addOnSuccessListener { result ->
            for (document in result) {
                var item = Item(
                    document.get("titulo").toString(),
                    document.get("descripcion").toString(),
                    document.get("id").toString()
                )
                lista.add(item)
            }
            rv.adapter = ItemAdapter(lista, "actividades")
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
         * @return A new instance of fragment FragmentMisActividades.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentMisActividades().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    fun deleteItem(item : Item){

        var db =Firebase.firestore
        //con esto borramos de la listas
        db.collection("lista_seleccionados").document(item.id).delete()
            .addOnFailureListener{ exception ->
                Toast.makeText(context,"error",Toast.LENGTH_LONG).show()
            }
    }
}