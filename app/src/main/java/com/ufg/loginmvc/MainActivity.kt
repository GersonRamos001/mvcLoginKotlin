package com.ufg.loginmvc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.myviewmodel.MyViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val viewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      //  viewModel = ViewModelProvider(this).get(viewModel::class.java)

        val usernameInput = findViewById<TextView>(R.id.txtName)
        val passwordInput = findViewById<TextView>(R.id.txtPass)
        val loginButton = findViewById<Button>(R.id.btnLogin)

        loginButton.setOnClickListener {
            viewModel.username = usernameInput.text.toString()
            viewModel.password = passwordInput.text.toString()
            if (viewModel.validateCredentials()) {
                // Inicio de sesión exitoso
                // Navegar a la pantalla principal de la aplicación
                Toast.makeText(this, "Credenciales validas", Toast.LENGTH_SHORT).show()
            } else {
                // Inicio de sesión fallido
                // Mostrar un mensaje de error al usuario
                Toast.makeText(this, "Credenciales inválidas", Toast.LENGTH_SHORT).show()
            }


        }
    }

}