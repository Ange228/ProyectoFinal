package com.example.flexapp.ui._.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.flexapp.databinding.ActivityDashboardBinding
import com.example.flexapp.ui._.shipping.register.ShippingRegisterBusinessActivity
import com.example.flexapp.ui.shipping.home.OrdersHistoryActivity

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Botón 1: Ir a Programar Envío (CAMBIO AQUÍ)
        binding.btnProgramarEnvio.setOnClickListener {
            val intent = Intent(this, ShippingRegisterBusinessActivity::class.java)
            startActivity(intent)
        }

        // Botón 2: Ir a Ver Historial
        binding.btnVerHistorial.setOnClickListener {
            val intent = Intent(this, OrdersHistoryActivity::class.java)
            startActivity(intent)
        }
    }
}
