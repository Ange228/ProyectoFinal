package com.example.flexapp.ui._.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.flexapp.databinding.ActivityMainBinding
import com.example.flexapp.ui._.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservers()
        setupUiListeners()

        // Inicia la carga (muestra loader dentro del ViewModel)
        quoteViewModel.onCreate()
    }

    private fun setupObservers() {
        // Observa el quote actual (texto principal y secundario)
        quoteViewModel.quoteModel.observe(this) { quote ->
            // Asegurarse de que quote no sea nulo antes de setear
            binding.tvQuote.text = quote?.quote ?: ""
            binding.tvMessage.text = quote?.message ?: ""
        }

        // Observa el loader (se mostrará solo al inicio mientras onCreate carga)
        quoteViewModel.isLoading.observe(this) { loading ->
            binding.progressBar.visibility = if (loading) View.VISIBLE else View.GONE

            // Mientras carga, evitamos que el usuario avance
            binding.viewContainer.isEnabled = !loading
        }

        // Observa si hay que mostrar el botón "Empezar" (solo en el último)
        quoteViewModel.showStartButton.observe(this) { show ->
            binding.btnEmpezar.visibility = if (show) View.VISIBLE else View.GONE
        }
    }

    private fun setupUiListeners() {
        // Avanzar mensaje cuando el usuario haga click en la pantalla (root)
        // Si estás en el último mensaje, el ViewModel no avanzará más (ni ocultará nada)
        binding.viewContainer.setOnClickListener {
            // Si el botón "Empezar" ya está visible, no avanzamos más
            if (binding.btnEmpezar.visibility == View.VISIBLE) return@setOnClickListener

            // Llamamos al ViewModel para avanzar al siguiente quote
            quoteViewModel.nextQuote()
        }

        // Botón Empezar: por ahora lo dejamos comentado hasta que tengas LoginActivity
        binding.btnEmpezar.setOnClickListener {
            // Navegación al LoginActivity (descomenta cuando exista)
            // val intent = Intent(this, LoginActivity::class.java)
            // startActivity(intent)
            // finish()
        }
    }
}
