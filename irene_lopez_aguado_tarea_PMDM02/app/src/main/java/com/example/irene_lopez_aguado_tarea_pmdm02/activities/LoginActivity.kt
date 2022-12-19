package com.example.irene_lopez_aguado_tarea_pmdm02.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.irene_lopez_aguado_tarea_pmdm02.R
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    lateinit var user:String
    lateinit var passw:String
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var authStateListener: FirebaseAuth.AuthStateListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnEntrar = findViewById(R.id.log_btn_entrar) as Button

        ///Leemos al usuario
        var usuario: TextInputLayout = findViewById(R.id.outlinedTF_Usuario) as TextInputLayout
        var inputText_usuario = usuario.editText?.text.toString()
        ///Leemos la contraseña
        var password: TextInputLayout = findViewById(R.id.outlinedTF_password) as TextInputLayout
        var inputText_password = password.editText?.text.toString()

        //Inicializamos las variables de firebase
        firebaseAuth = Firebase.auth

        usuario.editText?.doOnTextChanged(){
            inputText, _, _, _ ->
                //Respond to input text change
            user = inputText.toString()
        }
        password.editText?.doOnTextChanged(){
                inputText, _, _, _ ->
            //Respond to input text change
            passw = inputText.toString()
        }

        //Terminamos de leer usuario
        btnEntrar.setOnClickListener{
            signIn(user, passw)
        }
    }

    private fun signIn(email: String, password: String){
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                task->
                if(task.isSuccessful){
                    val user = firebaseAuth.currentUser
                    Toast.makeText(baseContext, "Bienvenido a tu hotel!", Toast.LENGTH_SHORT).show()
                    //aquí vamos al MainActivity
                    guardarEnsharedPref(getString(R.string.log_key))
                }else{
                    val user = firebaseAuth.currentUser
                    Toast.makeText(baseContext, "Error de email y/o contraseña", Toast.LENGTH_SHORT).show()
                    //aquí vamos al MainActivity
                }
            }
    }

    //getString(R.string.log_preference_file_key)
    //getString(R.string.log_key)

    
    fun guardarEnsharedPref(nombre_archivo_xml:String) {
        /*SHAREDPREFERENCES*/
        //Accedemos la fichero SharedPreferences
        val sharedPref = applicationContext.getSharedPreferences(nombre_archivo_xml, Context.MODE_PRIVATE)

        //Guardar un valor en el fichero de SharedPreferences por medio del editor de SharedPreferences
        with(sharedPref.edit()) {
            putString("Nombre", user)
            apply() //Escribe en el fichero de manera asíncrona (para no bloquear el hilo main)
        }

        val intent = Intent(this@LoginActivity, MainActivity::class.java)

        startActivity(intent)
    }
}