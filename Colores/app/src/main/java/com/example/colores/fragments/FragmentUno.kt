package com.example.colores.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.colores.R
import com.google.android.gms.tagmanager.Container

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentUno.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentUno : Fragment() {
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
        //Para manejar el botón del fragment uno

        // Inflate the layout for this fragment --> hacemos disponibles los elementos del fragment
        // container es el activity que va a tener el fragment y
        // la parte última es para cargar la vista, pero siempre poner en false

        val fragmentUno =inflater.inflate(R.layout.fragment_uno, container, false)

        val btnF1 = fragmentUno.findViewById(R.id.btn_fragment_uno) as Button

        btnF1.setOnClickListener {
            fragmentUno.setBackgroundColor(Color.YELLOW)
            // quiero el contexto del fragment, es decir el MainActivityFragments
            Toast.makeText(container?.context, "Has pulsado el botón del Fragment Uno", Toast.LENGTH_SHORT).show()
        }
    return fragmentUno
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentUno.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentUno().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}