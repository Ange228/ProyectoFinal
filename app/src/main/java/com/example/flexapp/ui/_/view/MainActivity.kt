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

        quoteViewModel.quoteModel.observe(this) { quote ->

            binding.tvQuote.text = quote?.quote ?: ""
            binding.tvMessage.text = quote?.message ?: ""
        }

        // Observa el loader (se mostrará solo al inicio mientras onCreate carga)
        quoteViewModel.isLoading.observe(this) { loading ->
            binding.progressBar.visibility = if (loading) View.VISIBLE else View.GONE

            // Mientras carga, evitamos que el usuario avance
            binding.viewContainer.isEnabled = !loading
        }

        quoteViewModel.showStartButton.observe(this) { show ->
            binding.btnEmpezar.visibility = if (show) View.VISIBLE else View.GONE
        }
    }

    private fun setupUiListeners() {

        binding.viewContainer.setOnClickListener {
            if (binding.btnEmpezar.visibility == View.VISIBLE) return@setOnClickListener

            quoteViewModel.nextQuote()
        }

        binding.btnEmpezar.setOnClickListener {

            val intent = Intent(this, RegisterBusinessActivity::class.java)
            startActivity(intent)
        }

    }
}

